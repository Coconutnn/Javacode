/*数组中重复的数字

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
请找出数组中任意一个重复的数字
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set =new HashSet<Integer>(); 
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return nums[i];
            } 
        }
        return 0;
    }
}
/*合并排序的数组
给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0&&j>=0){
            if(A[i]<B[j]){
                A[k--]=B[j--];
            }else{
                A[k--]=A[i--];
            }
        }
        while(j>=0){
            A[k--]=B[j--];
        }
    }
}