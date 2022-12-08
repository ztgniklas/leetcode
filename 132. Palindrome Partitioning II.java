// Using dp to store palindrome partition in s as 131
// Then use dp again, dp[i] denotes the min cut of s[0:i]
class Solution {
    public int minCut(String s) {
        // pld[i][j] = pld[i+1][j-1] && s[i] == s[j]
        boolean[][] pld = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                pld[i][j] = i == j || i + 1 == j && s.charAt(i) == s.charAt(j) || s.charAt(i) == s.charAt(j) && pld[i + 1][j - 1];  
            }
        }
        
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            if (pld[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (pld[j + 1][i]) {
                    min = Math.min(min, 1 + dp[j]);
                }
            }
            dp[i] = min;
        }
        
        return dp[s.length() - 1];
    }
}