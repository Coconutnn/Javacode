/*零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
*/
lass Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i]=amount+1;
        }
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
           }
       }
       return (dp[amount]==amount+1)?-1:dp[amount];
    }
}
//凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
//所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
//dp[i] i代表金额为i时所需最少硬币个数