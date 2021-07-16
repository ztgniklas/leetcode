/**
 * 分治法，要进行剪枝，有些子树没必要继续迭代
 */
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum = 0;
        helper(root, low, high);
        return this.sum;
    }
    
    private void helper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        // pruning
        if (root.val <= low) {
            helper(root.right, low, high);
        } else if (root.val >= high) {
            helper(root.left, low, high);
        } else {
            helper(root.right, low, high);
            helper(root.left, low, high);
        }
    }
}