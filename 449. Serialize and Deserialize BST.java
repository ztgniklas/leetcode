/**
 * 使用前序遍历序列化，这样在还原树结构是能方便的找到当前root和左右子树root，
 * 递归下去即可全部还原
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.length() <= 0 ? " " : sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strVals = data.split(" ");
        if (strVals.length <= 0) {
            return null;
        }
        int[] vals = new int[strVals.length];
        for (int i = 0; i < strVals.length; i++) {
            vals[i] = Integer.parseInt(strVals[i]);
        }
        TreeNode root = new TreeNode(vals[0]);
        deserializeHelper(vals, root, 0, vals.length);
        return root;
    }
    
    // recursively serializeing with preorder
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + " ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
    // root is the root of current subtree, with root.val == vals[start]
    // dealing with the values in [start, end)
    private void deserializeHelper(int[] vals, TreeNode root, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int divIdx = -1;
        for (int i = start + 1; i < end; i++) {
            if (vals[i] > root.val) {
                divIdx = i;
                break;
            }
        }
        if (divIdx > start + 1) {
            TreeNode left = new TreeNode(vals[start + 1]);
            root.left = left;
            deserializeHelper(vals, left, start + 1, divIdx);
            TreeNode right = new TreeNode(vals[divIdx]);
            root.right = right;
            deserializeHelper(vals, right, divIdx, end);
        } else if (divIdx == start + 1) {
            // no left subtree
            TreeNode right = new TreeNode(vals[divIdx]);
            root.right = right;
            deserializeHelper(vals, right, divIdx, end);
        } else {
            // divIdx == -1, no right subtree
            if (start + 1 < vals.length) {
                TreeNode left = new TreeNode(vals[start + 1]);
                root.left = left;
                deserializeHelper(vals, left, start + 1, end);
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));