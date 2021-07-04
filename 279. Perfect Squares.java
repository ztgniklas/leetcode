/*
dp思想
dp[i]表示i的最少平方数划分，dp[0]=0,dp[1]=1...
可推出一般结论dp[n]=min(dp[n-i*i]+1), i>0
注意对本身就是perfect squares number的n首先判断
*/
class Solution {
    public int numSquares(int n) {
        if(n==0)
            return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<n+1;i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt==i){
                dp[i] = 1;
                continue;
            }               
            for(int j=1;j<=sqrt;j++){
                if(i-j*j>=0){
                    dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
                }
            }
        }
        return dp[n];
    }
}

