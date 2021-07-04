/**
 * 对于以特定节点为root的树，我们用某种方式序列化
 * 用序列化后的字符串来表示这棵树（注意值与值分隔）
 * 这样，就可以维护一个全局的集合，以序列化的字符串为key存储遍历过的树
 * 一旦发现当前树已存在在集合中，就加入结果列表中即可（注意去重）
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> subtrees = new ArrayList<>();
        helper(root, new HashMap<>(), subtrees);
        return subtrees;
    }
    
    private String helper(TreeNode curRoot, Map<String, Boolean> rootStrs, List<TreeNode> subtrees) {
        if (curRoot == null) {
            return "#";
        }
        String rootStr = curRoot.val + "|" + helper(curRoot.left, rootStrs, subtrees) + helper(curRoot.right, rootStrs, subtrees);
        if (rootStrs.containsKey(rootStr)) {
            if (!rootStrs.get(rootStr)) {
                subtrees.add(curRoot);
                rootStrs.put(rootStr, true);
            }
            
        } else {
            rootStrs.put(rootStr, false);
        }
        return rootStr;
    }
}