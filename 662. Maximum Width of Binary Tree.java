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
    public int widthOfBinaryTree(TreeNode root) {
        int width = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 0);
        while (!queue.isEmpty()) {
            int size = queue.size(), start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == 0) {
                    start = map.get(curNode);
                }
                if (i == size - 1) {
                    end = map.get(curNode);
                }
                
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    map.put(curNode.left, map.get(curNode) * 2);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    map.put(curNode.right, map.get(curNode) * 2 + 1);
                }
            }
            width = Math.max(width, end - start + 1);
            
        }
        return width;
    }
}