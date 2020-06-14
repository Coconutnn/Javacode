//最短无序连续子数组
/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int r = 0;
        int []num = nums.clone();
        Arrays.sort(num);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=num[i]){
                r = Math.max(r,i);
                l = Math.min(l,i);
            }
        }
        return r-l>0?r-l+1:0;
    }
}