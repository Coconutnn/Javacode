import java.util.Arrays;

public class Demo1 {
    //不使用临时变量交换两个数的值
    public static void main(String[] args) {
        Demo1 a = new Demo1();
        int []A = {5,6};
        int []B= a.exchangeAB(A);
        System.out.println(Arrays.toString(B));
    }
        public int[] exchangeAB(int[] AB) {
            // write code here
            AB[0] = AB[0]+AB[1];
            AB[1] = AB[0]-AB[1]*2;//A0-A1
            AB[1] = (AB[0]+AB[1])/2;
            AB[0] = AB[0]-AB[1];
            return AB;
        }

}
