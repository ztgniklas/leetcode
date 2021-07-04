class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null)
            flatten(root.right);
        else{
            TreeNode tn1 = root.left;
            while(tn1.right!=null){
                tn1 = tn1.right;
            }
            tn1.right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
        }
        
            
    }
}