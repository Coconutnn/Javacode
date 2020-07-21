/*
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        int newlen = str.length()+count*2;
        int i = str.length()-1;
        int j = newlen-1;
        str.setLength(newlen);//设置新字符串大小
        while(i >= 0 && j >= 0){
            if(str.charAt(i)==' '){
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
                i--;
            }else{
                str.setCharAt(j--,str.charAt(i--));
            }
        }
        return str.toString();
    }
}