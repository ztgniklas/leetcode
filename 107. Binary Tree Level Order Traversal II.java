/*
与102题几乎一样，只不过因为是自底向上输出，所以使用add(0,aLevel)的方法每次把一层添加到开始位置。
也可以使用Collections.reverse(levels)，把102题自顶向下结果直接反转
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null)
            return levels;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> aLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                aLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                
            }
            levels.add(0,aLevel);
        }
        return levels;
    }
}