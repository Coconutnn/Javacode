/*剑指 Offer 67. 把字符串转换成整数
示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
*/
class Solution {
    public int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if(s.length==0){
            return 0;
        }
        int flag =1;
        int i=0;
        long res=0;
        if(s[0]=='-'){
            flag=-1;
            i=1;
        }
        if(s[0]=='+')i=1;
        for(int j =i;j<s.length;j++){
            if(s[j]<'0'||s[j]>'9'){
                break;
            }else{
                res = res*10+(s[j]-'0');
            }
            if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
            return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;    
        }
        return (int)res*flag;
    }
}