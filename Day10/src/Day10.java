import java.util.Scanner;

public class Day10 {
    //给一个数求最少多少步可以变为斐波那契数
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        int first = 0;
        int second = 1;
        int temp =0;
        if(n==1||n==0){
            System.out.println(0);

        }
        while (true){
            temp = first;
            first = second;
            second = temp + first;
            if(n>first&&n<=second){
                int step = Math.min(n-first,second-n);
                System.out.println(step);
                break;
            }
        }
    }
}
