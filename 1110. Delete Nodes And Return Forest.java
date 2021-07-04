/**
 * 注意放根结点，以及删除后续被删除但已经放入list中的结点
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> rst = new ArrayList<>();
        Set<Integer> toDelSet = new HashSet<>();
        for (int node : to_delete) {
            toDelSet.add(node);
        }
        if (!toDelSet.contains(root.val)) {
            rst.add(root);
        }
        delNodesHelper(root, toDelSet, rst);
        return rst;
    }
            
    public void delNodesHelper(TreeNode root, Set<Integer> to_delete, List<TreeNode> roots) {
        if (to_delete.contains(root.val)) {
            if (roots.contains(root)) {
                roots.remove(root);
            }
            if (root.left != null) {
                roots.add(root.left);
            }
            if (root.right != null) {
                roots.add(root.right);
            }
        }
        if (root.left != null) {
            delNodesHelper(root.left, to_delete, roots);
            if (to_delete.contains(root.left.val)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            delNodesHelper(root.right, to_delete, roots);
            if (to_delete.contains(root.right.val)) {
                root.right = null;
            }
        }
    }
}