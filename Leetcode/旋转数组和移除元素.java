//旋转数组
/*给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
*/
class Solution {
    public void rotate(int[] nums, int k) {
        for(int j=0;j<k;j++){
        int last =nums[nums.length-1];
            for(int i =nums.length-1 ;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=last;
        }      
    }
}
/*移除元素
示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int j=0;
         for(int i =0;i<nums.length;i++){
             if(nums[i]!=val){
                 nums[j++]=nums[i];
             }
         }
         return j;
    }
}