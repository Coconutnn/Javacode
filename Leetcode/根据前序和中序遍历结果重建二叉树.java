/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null){
            return null;
        }
        return treeCore(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode treeCore(int[] pre,int prestart,int preend,int[] in,int instart,int inend){
        //递归出口
        if(prestart > preend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        for(int i = instart; i < in.length; i++){//在中序序列中找根节点，分成左右子树
            if(pre[prestart]==in[i]){
				//根据中序，我们能确认左子树的节点个数是：i - inStart (没有从0开始哦) 
				//所以，需要从preStart+1，连续i - inStart个元素，就是左子树的前序序列末尾，再减1，所以就是prestart+i-instart
                root.left = treeCore(pre,prestart+1,prestart+i-instart,in,instart,i-1);
                root.right = treeCore(pre,prestart+i-instart+1,preend,in,i+1,inend);
                break;
            }
        }
        return root;
    }
}