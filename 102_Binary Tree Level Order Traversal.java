/*
递归法。对每一层level，先看当前这一层中有没有数据，如果没有就先创建这一层的数组。
之后直接把节点自己加进去就行，下一层按从左到右递归即可
*/
class Solution {
    public void nLevelOrder(TreeNode root,int level,List<List<Integer>> rst){
        if(root==null)
            return;
        if(rst.size()<level+1){
            List<Integer> lst = new ArrayList<>();
            rst.add(lst);
        }
        rst.get(level).add(root.val);
        nLevelOrder(root.left,level+1,rst);
        nLevelOrder(root.right,level+1,rst);
            
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        nLevelOrder(root,0,rst);
        return rst;
    }
}

/*
非递归，用BFS
使用队列，进结点，每出一个节点，就把该节点的左右子节点进入队列，这样就能按层次遍历所有结点了
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> aLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                aLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }  
            levels.add(aLevel);
        }
        return levels;
    }
}