public class Day102 {
    //有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
    //给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
    public static void main(String[] args) {
        Day102 m = new Day102();
        System.out.println(m.Unique(3,4));
    }
    public int Unique(int m,int n){
        int [][] a = new int[m][n];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    a[i][j]=1;
                }else {
                    a[i][j]=a[i-1][j]+a[i][j-1];
                }
            }
        }
        return a[m-1][n-1];
    }
}

