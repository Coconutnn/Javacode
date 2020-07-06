/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
回溯算法
for 选择 in 选择列表:
    # 做选择
    将该选择从选择列表移除
    路径.add(选择)
    backtrack(路径, 选择列表)
    # 撤销选择
    路径.remove(选择)
    将该选择再加入选择列表
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track,res);
        return res;
    }
// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
    public static void backtrack(int[] nums,LinkedList<Integer> track,List<List<Integer>> res){
        //结束条件
		if(track.size()==nums.length){
            res.add(new LinkedList<>(track));//走到底了添加返回链表的拷贝
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){//已选择则继续
                continue;
            }
            track.add(nums[i]);//做选择
            backtrack(nums,track,res);//递归，进入下一层决策树
            track.removeLast();撤销选择
        }
    }
}