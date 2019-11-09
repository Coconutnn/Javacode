public class Test {
    public static void main(String[] args) {
        double d = Math.random();//返回【0，1）之间的随机数
        System.out.println(d);
        int i = (int)(Math.random()*6 + 1);//返回【1，6】之间的随机数
        System.out.println(i);
    }
}
