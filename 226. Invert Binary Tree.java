/*
反转二叉树
把当前根节点的左右两个子树调换，至于子树自己的调换过程用递归解决
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        if(root.right == null && root.left == null)
            return root;
        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }
}