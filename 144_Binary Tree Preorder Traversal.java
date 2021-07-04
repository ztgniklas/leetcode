class Solution {
    List<Integer> lst = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return lst;
        lst.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return lst;
    }
}

/*
preorder是根左右遍历
使用递归法很简单，因为对于一个结点的左子节点和右子结点具体是怎么遍历的不用多管。
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> rst = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                rst.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.getLast().right;
            stack.removeLast();
        }
        return rst;
    }
}

/*
用栈解决。
先一个劲遍历左子结点，直到当前结点是null，之后把当前节点的父节点，也就是当前栈尾弹出，把当前节点变为父节点的右子节点，再重复以上过程。
注意：只有当当前节点不是null时，才将其值写到输出结果序列中
*/