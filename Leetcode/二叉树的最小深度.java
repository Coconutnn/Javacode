/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
*/
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;//1.根节点为空，返回0
        if(root.left == null && root.right == null) return 1;//2.叶子节点返回1
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if(root.left==null || root.right==null) return m1+m2+1;//3.左或右一个为空，返回不为空的深度+1，为空的为0
        return Math.min(m1,m2)+1;//4.左右孩子都不为空，深度+1
    }
}
//用BFS广度优先遍历的方法做
class Solution {
    public int minDepth(TreeNode root) {
       if(root==null)return 0;
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       int depth =1;
       while(!q.isEmpty()){
           int size = q.size();
           for(int i=0;i<size;i++){
               TreeNode cur = q.poll();
               if(cur.left==null&&cur.right==null)
                    return depth;
               if(cur.left!=null) 
                    q.offer(cur.left);
               if(cur.right!=null)
                    q.offer(cur.right);
           }
           depth++;
       }
       return depth;
    }
}

/*二叉树最大深度*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}