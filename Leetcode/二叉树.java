相同的树
public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&q==null) return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
}


判断是否是一个树的子树
class Solution {
    //判断是否是子树
    public boolean isSubtree(TreeNode s,TreeNode t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.val==t.val)
            return isEqual(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //判断两树相等
    public boolean isEqual(TreeNode m,TreeNode n){
        if(m==null&&n==null)return true;
        if(m==null||n==null)return false;
        if(m.val == n.val)
            return isEqual(m.left,n.left)&&isEqual(m.right,n.right);
        return false;
    }
}


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