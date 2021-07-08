/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        return helper(root)[0];
    }
    
    // int[] {max, maxMustThroughRootFromOnSide}
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {-1001, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[] {root.val, root.val};
        }
        int curVal = root.val;
        int[] left = helper(root.left), right = helper(root.right);
        return new int[] {Math.max(curVal + right[1], Math.max(curVal + left[1], Math.max(curVal, Math.max(right[0], Math.max(curVal + left[1] + right[1], left[0]))))), Math.max(curVal + Math.max(left[1], right[1]), curVal)};
    }
}