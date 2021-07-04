/**
 * 分治法，对于当前节点，分别获取左子树和右子树的最长路径和必须经过左右子树根节点一侧的最长路径
 * 计算经过当前节点一侧的最长路径并对比得当前数中得最长路径（不一定过当前节点）
 * 递归向上到根节点，注意节点为null的时候的取值
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[0];
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        return new int[]{Math.max(Math.max(left[1] + right[1] + 2, left[0]), right[0]), 1 + Math.max(left[1], right[1])};
    }
}