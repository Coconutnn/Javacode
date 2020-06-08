package lab;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.nlpcn.commons.lang.occurrence.Count;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadCatch {
    public static class Job implements Runnable{
        private String url;

        private DataSource dataSource;
        private CountDownLatch countDownLatch;

        public  Job(String url,DataSource dataSource,CountDownLatch countDownLatch){
            this.url = url;

            this.dataSource = dataSource;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {

            WebClient client = new WebClient(BrowserVersion.CHROME);
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);
            try{
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                HtmlPage page = client.getPage(url);
                String xpath;
                DomText domText;
                xpath = "//div[@class='cont']/h1/text()";
                domText = (DomText) page.getBody().getByXPath(xpath).get(0);
                String title = domText.asText();

                xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
                domText = (DomText) page.getBody().getByXPath(xpath).get(0);
                String dynasty = domText.asText();

                xpath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
                domText = (DomText) page.getBody().getByXPath(xpath).get(0);
                String author = domText.asText();

                xpath = "//div[@class='cont']/div[@class='contson']";
                HtmlElement element = (HtmlElement) page.getBody().getByXPath(xpath).get(0);
                String content = element.getTextContent().trim();

                //1.计算sha-256
                String s = title + content;
                messageDigest.update(s.getBytes("UTF-8"));
                byte[] result = messageDigest.digest();
                StringBuilder sha256 = new StringBuilder();
                for (byte b:result){
                    sha256.append(String.format("%02x",b));
                }
                //2.计算分词
                List<Term> termList = new ArrayList<>();
                termList.addAll(NlpAnalysis.parse(title).getTerms());
                termList.addAll(NlpAnalysis.parse(content).getTerms());
                List<String> words = new ArrayList<>();
                for(Term term:termList){
                    if(term.getNatureStr().equals("w")){
                        continue;
                    }
                    if(term.getNatureStr().equals("null")){
                        continue;
                    }
                    if(term.getRealName().length()<2){
                        continue;
                    }
                    words.add(term.getRealName());
                }
                String insertWords = String.join(",",words);
                try(Connection connection = dataSource.getConnection()) {
                    String sql = "INSERT INTO t_tangshi" +
                            "(sha256,dynasty,title,author," +
                            "content,words)" +
                            "VALUES(?,?,?,?,?,?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, sha256.toString());
                        statement.setString(2, dynasty);
                        statement.setString(3, title);
                        statement.setString(4, author);
                        statement.setString(5, content);
                        statement.setString(6, insertWords);
                        com.mysql.jdbc.PreparedStatement mysqlStaement = (com.mysql.jdbc.PreparedStatement) statement;
                        System.out.println(mysqlStaement.asSql());
                        statement.executeUpdate();

                    }
                }
            }catch (SQLException e) {
                if(!e.getMessage().contains("Duplicate entry")){
                    e.printStackTrace();
                }
            }catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(30);
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        String baseUrl = "https://so.gushiwen.org";
        String pathUrl = "/gushi/tangshi.aspx";
        List<String> detailUrlList = new ArrayList<>();
        {
            String url = baseUrl+pathUrl;
            HtmlPage page = client.getPage(url);
            List<HtmlElement> divs = page.getBody().getElementsByAttribute("div",
                    "class",
                    "typecont");
            for(HtmlElement div: divs){
                List<HtmlElement> as = div.getElementsByTagName("a");
                for(HtmlElement a:as){
                    String detailUrl = a.getAttribute("href");
                    detailUrlList.add(baseUrl+detailUrl);
                }
            }
        }

        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDatabaseName("tangshi");
        dataSource.setUseSSL(false);
        dataSource.setCharacterEncoding("UTF8");

        System.out.println("一共有"+detailUrlList.size()+"首诗");

        CountDownLatch countDownLatch = new CountDownLatch(detailUrlList.size());
        //详情页请求和解析
        for (String url : detailUrlList){
            pool.execute(new Job(url,dataSource,countDownLatch));

        }
        //等待所有诗下载结束
        countDownLatch.await();
        pool.shutdown();
    }

}
