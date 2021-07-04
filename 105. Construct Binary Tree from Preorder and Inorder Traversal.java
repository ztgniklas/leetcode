/*
同时知道先序和中序
显然，先序中第一个节点肯定是根节点。知道了根节点后，由于中序是左-根-右，所以中序遍历在根节点左边的肯定是跟节点的左子树，右边的肯定是右子树。
对于每棵子树，递归重复以上过程
例如，preorder = [3,9,20,15,7]，inorder = [9,3,15,20,7]
显然3是根节点，再看inorder，9在3左子树上，[15,20,7]是右子树，且[20,15,7]是先序遍历，[15,20,7]是中序遍历
然后再构建9以及[15,20,7]......
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i=0;
        for(;i<inorder.length;i++){
            if(inorder[i]==root.val)
                break;
        }
        int[] lpreorder = new int[i];
        int[] linorder = new int[i];
        int[] rpreorder = new int[preorder.length-1-i];
        int[] rinorder = new int[preorder.length-1-i];
        for(int j=1;j<preorder.length;j++){
            if(j<=i)
                lpreorder[j-1] = preorder[j];
            else
                rpreorder[j-1-i] = preorder[j];
        }
        for(int j=0;j<preorder.length;j++){
            if(j<i)
                linorder[j] = inorder[j];
            else if(j>i)
                rinorder[j-1-i] = inorder[j];
        }
        root.left = buildTree(lpreorder,linorder);
        root.right = buildTree(rpreorder,rinorder);
        return root;
    }
}

/*
重写函数，只需指定索引即可，不许要单独生成新的pre和in数组
*/
class Solution {
    public TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart>preend || instart>inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootloc = 0;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==root.val){
                rootloc = i;
                break;
            }            
        }
        root.left = buildTree(preorder,prestart+1,prestart+rootloc-instart,inorder,instart,rootloc-1);
        root.right = buildTree(preorder,prestart+rootloc+1-instart,preend,inorder,rootloc+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
}

/*
改进：使用map先储存每个节点在中序数组中的位置，这样之后就不用每次都使用循环定位当前子树根节点在inorder中的位置了
时间：第一种方法13ms，第二种4ms，第三种1ms，使用map后性能提升还是很明显的
*/
class Solution {
    public TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,Map<Integer,Integer> hm){
        if(prestart>preend || instart>inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootloc = hm.get(root.val);        
        root.left = buildTree(preorder,prestart+1,prestart+rootloc-instart,inorder,instart,rootloc-1,hm);
        root.right = buildTree(preorder,prestart+rootloc+1-instart,preend,inorder,rootloc+1,inend,hm);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }
}