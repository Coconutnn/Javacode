/*字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
*/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res ="0";
        for(int i = num2.length()-1; i>=0; i--){
            int temp =0;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<num2.length()-1-i;j++){
                sb.append(0);
            }
            for(int k =num1.length()-1; k>=0||temp!=0; k--){
                int n1 = k>=0?num1.charAt(k)-'0':0;
                int n2 = num2.charAt(i)-'0';
                int num = n1*n2+temp;//计算相乘加进位总和
                temp = num/10;//进位
                sb.append(num%10);
            }
            res = addStrings(res,sb.reverse().toString());
        }
        return res;
    }
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder build =new StringBuilder();
        int temp =0;
        while(i>=0||j>=0||temp!=0){
            int n1 =i>=0?num1.charAt(i)-'0':0;
            int n2 =j>=0?num2.charAt(j)-'0':0;
            int n3 = n1+n2+temp;
            temp=n3/10;
            build.append(n3%10);
            i--;
            j--;
        }
        return build.reverse().toString();
    }
}