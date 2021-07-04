/**
 * 递归即可
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIdx = 0, maxNum = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = helper(nums, start, maxIdx);
        root.right = helper(nums, maxIdx + 1, end);
        return root;
    }
}