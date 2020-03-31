/*917. 仅仅反转字母
给定一个字符串 S，返回 “反转后的” 字符串，
其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

示例 1：

输入："ab-cd"
输出："dc-ba"
示
*/
class Solution {
    public String reverseOnlyLetters(String S) {
        char [] num =S.toCharArray();
        int j = num.length-1;
        for(int i=0;i<num.length;i++){
            if(num[i]>='a'&&num[i]<='z'||num[i]>='A'&&num[i]<='Z'){
                while(i<j){
                    if(num[j]>='a'&&num[j]<='z'||num[j]>='A'&&num[j]<='Z'){
                        char a = num[i];
                        num[i] = num[j];
                        num[j] = a;
                        j--;
                        break;
                    }     
                    j--;  
                }
            }
        }
        return new String(num);
    }
}