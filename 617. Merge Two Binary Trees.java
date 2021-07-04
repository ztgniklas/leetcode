/**
 * 经典分治法
 * 注意不同情况下的判空
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        helper(root, root1, root2);
        return root;
    }
    
    private void helper(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
        } else if (root1 != null) {
            root.val = root1.val;
        } else { // we limit that root1 and root2 must not be null neither
            root.val = root2.val;
        }
        
        if (root1 !=null && root1.left != null || root2 != null && root2.left != null) {
            TreeNode left = new TreeNode();
            root.left = left;
            helper(root.left, root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        }
        
        if (root1 != null && root1.right != null || root2 != null && root2.right != null) {
            TreeNode right = new TreeNode();
            root.right = right;
            helper(root.right, root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        }
    }
}