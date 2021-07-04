/*
对于一个正确的BST，以中序遍历的序列应该是一个升序序列
因此我们可以中序遍历，然后检验输出序列是不是满足升序的
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> inorder = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            
            root = stack.getLast();
            inorder.add(root.val);
            root = root.right;
            stack.removeLast();
            
        }
        for(int i=0;i<inorder.size()-1;i++){
            if(inorder.get(i)>=inorder.get(i+1))
                return false;
        }
        return true;
    }
}

/*
在加入序列时就判断，省去了最后的对比，会大幅降低运行时间
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> inorder = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            
            root = stack.getLast();
            if(inorder.isEmpty() || inorder.getLast()<root.val)
                inorder.add(root.val);
            else return false;
            root = root.right;
            stack.removeLast();
            
        }
        return true;
    }
}