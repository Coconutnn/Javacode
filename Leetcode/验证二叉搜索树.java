/*验证二叉搜索树
示例 1:

输入:
    2
   / \
  1   3
输出: true
*/
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}