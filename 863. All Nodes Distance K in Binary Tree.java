/**
 * 问题的症结就在于难以搜索target node非子树的nodes
 * 所以通过记录parent把树变成双向图即可变成普通的BFS寻路径问题
 */
class Solution {
    // node: its parent
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> rst = new ArrayList<>();
        dfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curN = queue.poll();
                if (visited.contains(curN.val)) {
                    continue;
                }
                // time for adding to result list
                if (k == 0) {
                    rst.add(curN.val);
                }
                visited.add(curN.val);
                if (curN.left != null) {
                    queue.offer(curN.left);
                }
                if (curN.right != null) {
                    queue.add(curN.right);
                }
                if (parent.get(curN) != null) {
                    queue.add(parent.get(curN));
                }
            }
            k--;
        }
        return rst;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }
        dfs(root.left);
        dfs(root.right);
    }
}