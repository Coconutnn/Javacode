/*100.相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
*/
public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&q==null) return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
	
	
	
/*572.另一个树的子树*/
	
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