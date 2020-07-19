/*
260. 只出现一次的数字 III
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :

输入: [1,2,1,3,2,5]
输出: [3,5]
*/
//用map保存每一个数字出现的次数
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int i=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                res[i++]=entry.getKey();
            }
        }
        return res;
    }
}
//位运算，所有数异或得到的数为1的位置说明两个元素二进制该位置不同
//找出该位置分成两类，1或0，分别异或
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int num=0;
        int temp =1;//记录第几位
        for(int n:nums){
            num ^=n;
        }
        while(true){
            if((num&temp)==temp){
                break;
            }
            temp=temp<<1;//temp二进制为1的位置就是num为1的位置
        }
        for(int n:nums){
            if((n&temp)==temp){
                res[0]^=n;
            }else{
                res[1]^=n;
            }
        }
        return res;
    }
}