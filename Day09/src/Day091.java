import java.util.Scanner;

public class Day091 {
// 输入一个正整数n，求n!末尾有多少个0
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int count = 0;
        for(int i=0;i<n;i++){
            n = n/5;
            count+=n;
        }
        System.out.println(count);
    }
}
