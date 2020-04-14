关于二叉树的深度优先遍历和广度广度遍历：
1、深度优先遍历常用的数据结构为栈，广度优先遍历常用的数据结构为队列
2、深度优先遍历的思想是从上至下，对每一个分支一直往下一层遍历直到这个分支结束，然后返回上一层，对上一层的右子树这个分支继续深搜，直到一整棵树完全遍历，因此深搜的步骤符合栈后进先出的特点
广度优先遍历的思想是从左至右，对树的每一层所有结点依次遍历，当一层的结点遍历完全后，对下一层开始遍历，而下一层结点又恰好是上一层的子结点。因此广搜的步骤符合队列先进先出的思想。
3、关于二叉树的深度优先搜索
则又有三种遍历方法
先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。
除了利用栈以外，深度优先搜索也可以使用递归的方法。’
4、深度优先搜索算法：不全部保留结点，占用空间少；有回溯操作(即有入栈、出栈操作)，运行速度慢。
广度优先搜索算法：保留全部结点，占用空间大； 无回溯操作(即无入栈、出栈操作)，运行速度快。

递归解法
//前序遍历
public static void preOrder(Node head){
    if(head==null){
        return;
    }
    System.out.println(head.value);
    preOrder(head.left);
    preOrder(head.right);
}

//中序遍历
public static void inOrder(Node head){
    if(head==null){
        return;
    }
    System.out.println(head.value);
    inOrder(head.left);
    inorder(head.right);
}

//后序遍历
public static void postOrder(Node head){
    if(head==null){
        return;
    }
    postOrder(head.left);
    postOrder(head.right)；
    System.out.println(head.value);
}


//迭代解法 stack
//前序遍历
1.判断root是否为空
2.把root入栈
3.循环条件栈非空
4.定义新节点出栈
5.读取该节点
6.该节点右非空入栈
7.该节点左非空入栈
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return list;
    }
    
//中序遍历
1.循环条件栈非空或root非空
2.循环只要root不为空入栈，root等于左
3.root等于出栈
4.读取root
5.root等于右

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root  = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    
  //后序遍历

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();   
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            list.addFirst(node.val);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
       return list;
    }