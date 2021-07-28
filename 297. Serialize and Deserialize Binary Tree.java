/**
 * 序列化时，使用bfs把每一层的节点值记录下来，为了能够反序列化，一个
 * 有效节点的左右子节点无论是否为null都要记录；
 * 反序列化时，根据完整二叉树每一层的节点数，1，2，4，8，...作为基准
 * 当前层每出现null，就说明下一层相比基准节点数要少两个，以此来确定下
 * 一层的范围。然后针对当前层每一个有效节点，依次将下一层的节点链接上
 * 去。之后再循环至下一层，做同样操作。
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> serTree = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    serTree.add("null");
                    continue;
                }
                serTree.add(String.valueOf(curNode.val));
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
        }
        return String.join(",", serTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // [1,2,3,null,null,4,5,null,6]
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        if (nodes.length == 0 || "null".equals(nodes[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevPt = 1, curLev = 1, curLevNum = 1;
        while (nextLevPt < nodes.length) {
            //for each level
            int nextLevNum = (int) Math.pow(2, curLev);
            for (int i = 0; i < curLevNum && nextLevPt < nodes.length; i++) {
                TreeNode curNode = queue.poll();
                if ("null".equals(nodes[nextLevPt])) {
                    curNode.left = null;
                    nextLevNum -= 2;
                } else {
                    curNode.left = new TreeNode(Integer.parseInt(nodes[nextLevPt]));
                    queue.offer(curNode.left);
                }
                nextLevPt++;
                if ("null".equals(nodes[nextLevPt])) {
                    curNode.right = null;
                    nextLevNum -= 2;
                } else {
                    curNode.right = new TreeNode(Integer.parseInt(nodes[nextLevPt]));
                    queue.offer(curNode.right);
                }
                nextLevPt++;
            }
            curLevNum = nextLevNum;
            curLev++;
        }
        return root;
    }
}