class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();      
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            rst.add(stack.getLast().val);
            root = stack.getLast().right;
            stack.removeLast();
            
        }
        return rst;
    }
}

/*
递归与144题类似
对于非递归，由于中序先输出左子结点，所以不能在遍历左子节点的同时把节点值输出。而是在一笔遍历左子节点走到头之后，才把栈尾输出，然后输出根节点，然后再转移到右子结点
*/