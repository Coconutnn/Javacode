import java.util.*;
public class Day092 {
    //将这个整数以字符串
        public static String reserve(int n){
            if(n<10)
                return Integer.toString(n);
            else
            {
                int m = n%10;
                n=n/10;
                return Integer.toString(m)+reserve(n);
            }
        }
        public static void main(String[] args){
            Scanner s =new Scanner(System.in);
            int n = s.nextInt();
            System.out.println(reserve(n));
        }

}
