/*
直接用递归，当前结点不是null，就已经有一层了，再加上左右子树层数最大的
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int depth = 1;
        return depth+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}