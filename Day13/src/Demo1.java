
import java.util.Scanner;

public class Demo1 {
//给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。
// 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
//
//现给定数字，请编写程序输出能够组成的最小的数。
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        //读取数字0-9的个数
        for (int i = 0; i < num.length; i++) {
            num[i] = in.nextInt();
        }
        in.close();
        //输出除0外最小的数字
        for (int i = 1; i < num.length; i++) {
            if (num[i] != 0) {
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        //由小到大从0开始输出
        for (int i = 0; i < num.length; i++) {
            while(num[i] > 0){
                System.out.print(i);
                num[i]--;
            }
        }
        System.out.println();
    }

}