/*最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        char[] str = s.toCharArray();
        int max =0;
        int ll =0;
        int rr = 0;
        for(int i=0;i<s.length();i++){
            int l =i-1;
            int r =i+1;
            while(l>=0&&r<s.length()&&str[l]==str[r]){
                int len = r-l+1;
                if(len>max){
                    max =len;
                    ll=l;
                    rr=r;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while(l>=0&&r<s.length()&&str[l]==str[r]){
                int len = r-l+1;
                if(len>max){
                    max =len;
                    ll=l;
                    rr=r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ll,rr+1);
    }
}