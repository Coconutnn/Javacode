/* 有字符串A和字符串B
寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
  例如：
  A  = “aba”，B = “b”。这里有4种把B插入A的办法：
  * 在A的第一个字母之前: "baba" 不是回文
  * 在第一个字母‘a’之后: "abba" 是回文
  * 在字母‘b’之后:      "abba" 是回文
  * 在第二个字母'a'之后  "abab" 不是回文
  所以满足条件的答案为2
  */

import java.util.Scanner;
public class Text {
    public static boolean isHuiwen(String a,int b,int c){
        while(b<c){
            if(a.charAt(b)!=a.charAt(c)){
                return false;
            }
            b++;
            c--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        int count = 0;

        for(int i = 0;i<=a.length();i++){
            if (isHuiwen(a.substring(0,i)+b+a.substring(i),0,a.length()+b.length()-1)){
                //subsring[ )
                count++;
            }
        }
        System.out.println(count);

    }
}
