//回文数
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        if(x==0)
        return true;
        if(x<0)
        return false;
        int temp=0;
        while(x>0){
            temp =temp*10+x%10;
            x=x/10;
        }
        return temp == num ? true:false;
    }
}