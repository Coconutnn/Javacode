/*只出现一次的数
输入: [2,2,1]
输出: 1
*/
//用hashset
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        int num =0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        for(int j=0;j<nums.length;j++){
            if(set.contains(nums[j])){
                num =nums[j];
            }
        }
        return num;
    }
}
//用异或
class Solution {
    public int singleNumber(int[] nums) {        
        int num =nums[0];
        for(int i=1;i<nums.length;i++){
            num=num^nums[i];
        }
        return num;
    }
}