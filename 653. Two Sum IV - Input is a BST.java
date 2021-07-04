/**
 * BFS+Set
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> hs = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                hs.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        for (int val : hs) {
            if (k != 2 * val && hs.contains(k - val)) {
                return true;
            }
        }
        return false;
    }
}