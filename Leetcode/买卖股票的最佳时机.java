/*121.买卖股票的最佳时机
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

*/
class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        if(prices.length<1){
            return max;
        }
        int min =prices[0];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]-min>max){
                max =prices[i]-min;
            }
            if(prices[i]<min){
                min = prices[i];
            }
        }
        return max;
    }
}