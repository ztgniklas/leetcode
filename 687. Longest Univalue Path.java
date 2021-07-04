class Solution {
    int len;
    public int longestUnivaluePath(TreeNode root) {
        len = 0;
        helper(root);
        return len;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left), right = helper(node.right), newL = 0, newR = 0;
        if (node.left != null && node.left.val == node.val) {
            newL = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            newR = right + 1;
        }
        len = Math.max(len, newL + newR);
        return Math.max(newR, newL);
    }
}