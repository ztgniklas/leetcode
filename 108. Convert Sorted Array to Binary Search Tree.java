/**
 * 常规分治法
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootIdx = (end + start + 1) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = helper(nums, start, rootIdx - 1);
        root.right = helper(nums, rootIdx + 1, end);
        return root;
    }
}