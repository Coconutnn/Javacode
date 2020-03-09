//1.递归解法
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


//2.迭代解法(stack)


//前序遍历

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
