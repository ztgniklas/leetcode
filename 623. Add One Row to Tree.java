/**
 * 先通过BFS找到需要插入那一层的所有父node
 * 执行插入操作即可，和链表的插入类似
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val, root, null);
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int curDepth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (curDepth == depth - 1) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                
            }
            curDepth++;
        }
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = curNode.left;
            curNode.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = curNode.right;
            curNode.right = newRight;
        }
        return root;
    }
}