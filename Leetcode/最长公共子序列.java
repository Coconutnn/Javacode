/*最长公共子序列
示例 1:

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i=1;i<=s1.length;i++){
            for(int j=1;j<=s2.length;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
/*
(1) 如果S的最后一位等于T的最后一位，则最大子序列就是{s1,s2,s3...si-1}和{t1,t2,t3...tj-1}的最大子序列+1

(2) 如果S的最后一位不等于T的最后一位，那么最大子序列就是

① {s1,s2,s3..si}和 {t1,t2,t3...tj-1} 最大子序列

② {s1,s2,s3...si-1}和{t1,t2,t3....tj} 最大子序列

以上两个自序列的最大值
*/