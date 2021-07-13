/**
 * 保存当前的最大值和一条分支的最大值
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

/**
 * 更简洁的做法是维护全局的最大值，并且考虑到负值，分支的值要与0比大小
 */
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}