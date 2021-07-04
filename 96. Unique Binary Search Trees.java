/*
96. Unique Binary Search Trees
dp[i]表示1...i的unique BST个数
f[i,n]表示在求dp[n]的语境下，以i为根节点的unique BST个数
注意，为了表示的唯一性，当以i为根节点时，1...i-1必须在i的左子树上，i+1...n必须在i的右子树上，至于这些子树的排列方式就是递归问题了。
例如，求dp[3]，即序列[1,2,3]
当我们选择2为根节点时，左子树只有1，右子树只有3，各只有1种排列，所以总共只有1*1种排列：
  2
 / \
1   3
当选择3为根节点时，则要考虑左子树[1,2]有几个unique BST，也是若1为根...若2为根...递归下去
当选择1为根节点时，则要考虑右子树[2,3]有几个unique BST。注意此时我们考虑[2,3]实际上和[1,2]是等价的，也就是求dp[2]，即一旦确定了根节点，我们就只考虑子树的数量属性了
所以，dp[n]=f[1,n]+f[2,n]+...+f[n,n]，
而f[i,n]=dp[[1...i-1]的个数]*dp[[i+1...n]的个数]=dp[i-1]*dp[n-i]
*/
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        //int[] f = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                int left = j-1;
                int right = i-j;
                dp[i] += dp[left]*dp[right];
            }
        }
        return dp[n];
        
    }
}