// 排列组合
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // dp[i] = dp[i - 1] + 9*9*8
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int newNum = 9;
            for (int j = 1; j < i; j++) {
                newNum *= (9 - j + 1);
            }
            dp[i] = dp[i - 1] + newNum;
        }
        return dp[n];
    }
}