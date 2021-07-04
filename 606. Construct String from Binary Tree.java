class Solution {
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            sb.append(tree2str(root.left));
            sb.append(")");
            if (root.right != null) {
                sb.append("(");
                sb.append(tree2str(root.right));
                sb.append(")");
            }
        } else {
            if (root.right != null) {
                sb.append("()");
                sb.append("(");
                sb.append(tree2str(root.right));
                sb.append(")");
            }
        }
        return sb.toString();
    }
}