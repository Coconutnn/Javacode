//二叉树的最大深度
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}

/*平衡二叉树

给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true;
        return Math.abs(height(root.left)-height(root.right))<2
        && isBalanced(root.left)
        && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null)
        return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}




//对称二叉树
/*给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
        return isduichen(root.left,root.right);
    }
    public boolean isduichen(TreeNode left,TreeNode right){
        if(left==null&&right==null)
        return true;
        if(left==null||right==null)
        return false;
        return (left.val==right.val)
        && isduichen(left.left,right.right)
        && isduichen(left.right,right.left);
    }
}
