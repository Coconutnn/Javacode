/*组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
//与全排列类似
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>(); 
        backTrack(list,res,n,k,1);
        return list;
    }
    public static void backTrack(List<List<Integer>> list,LinkedList<Integer> res,int n,int k,int first){
        if(res.size()==k){
            list.add(new LinkedList<>(res));
            return;
        }
        for(int i=first;i<=n;i++){
            res.add(i);
            backTrack(list,res,n,k,i+1);
            res.removeLast();
        }
    }
}