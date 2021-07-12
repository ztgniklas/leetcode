/**
 * 层次遍历从左到右取每层最后一个node即可
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode levNode = null;
            for (int i = 0; i < size; i++) {
                levNode = queue.poll();
                if (levNode.left != null) {
                    queue.offer(levNode.left);
                }
                if (levNode.right != null) {
                    queue.offer(levNode.right);
                }
            }
            rst.add(levNode.val);
        }
        return rst;
    }
}