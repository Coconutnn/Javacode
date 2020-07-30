/*二叉树的层序遍历*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode father = q.poll();
            result.add(father.val);
            if(father.left!=null)
                q.offer(father.left);
            if(father.right!=null)
                q.offer(father.right);
        }
        return result;
    }
}