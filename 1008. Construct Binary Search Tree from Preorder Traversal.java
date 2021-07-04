/**
BST得前序遍历数组，第0个是root，之后第一个比root大的是右子树的root，由此划分出左右子树的range
对左右子树递归调用上述方法即可
注意：记录index就可以，不要复制数组，防止MLE
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int rightIdx = start + 1;
        for (; rightIdx < end; rightIdx++) {
            if (preorder[rightIdx] > root.val) {
                break;
            }
        }
        root.left = bstFromPreorder(preorder, start + 1, rightIdx);
        root.right = bstFromPreorder(preorder, rightIdx, end);
        return root;
    }
}