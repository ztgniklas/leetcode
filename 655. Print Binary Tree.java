/**
 * 按照规则处理每个节点，然后对左右子节点递归处理
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int colNum = (int) (Math.pow(2, height) - 1);
        List<List<String>> mat = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < colNum; j++) {
                row.add("");
            }
            mat.add(row);
        }
        fillRows(root, mat, 0, 0, colNum - 1);
        return mat;
    }
    
    private void fillRows(TreeNode curNode, List<List<String>> mat, int row, int start, int end) {
        if (curNode == null) {
            return;
        }
        List<String> rowData = mat.get(row);
        int curLoc = (int) Math.ceil((start + end) / 2f);
        rowData.set(curLoc, curNode.val + "");
        fillRows(curNode.left, mat, row + 1, start, curLoc - 1);
        fillRows(curNode.right, mat, row + 1, curLoc + 1, end);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}