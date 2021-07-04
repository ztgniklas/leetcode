class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr:dp)
            Arrays.fill(arr,0);
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    dp[i][j] = 1;
                }              
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

/*
注意本题是求子序列，bbbb也是bbbab的一个子序列
使用dp思想
dp[i][j]表示s[i:j+1]中最长的回文序列的长度
如果i==j，即一个字母，肯定是长度为1的回文，此时dp[i][j]=1
否则如果s[i]==s[j]，如b[...]b，这时整个字符串的最大回文长度肯定是[...]中的最大长度+2了，即dp[i][j]=dp[i+1][j-1]+2
否则，最一般的情况，当前串长度大于1而且首尾不相同，如a[...]b，那就分别查看a[...]和[...]b中最长的回文序列的长度，取最大即可，即dp[i][j]=max(dp[i][j-1],dp[i+1][j])
最后dp[0][s.length()-1]就对应整个字符串中最长的回文序列的长度，即所求
把二维矩阵画出更容易理解
*/