/**
 * 由题意可知，root.val一定是最小值
 * 因为是找第二小的，所以如果一个node的val>最小值，那么鉴于其子树的node值
 * 一定是不小于该node的，所以就没必要在其子树继续搜索了（该node即为备选）
 * 如果node.val == min 且子树node值都是min或者没有子节点，则返回-1
 * 这样递归左右子树，即可得到左右子树各自的备选值，对比即可
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }
    
    private int helper(TreeNode node, int min) {
        if (node == null) {
            return -1;
        }
        // no need to go on searching its subtree
        if (node.val > min) {
            return node.val;
        }
        // node.val == min
        int left = helper(node.left, min);
        int right = helper(node.right, min);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left == -1) {
            return right;
        }
        return left;
        
    }
}