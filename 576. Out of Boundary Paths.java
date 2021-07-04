/**
 * 使用BFS会TLE
 * 在暴力递归法的基础上，存储已经走过的特定步数的坐标的路径数
 * 如cache[x][y][n]表示在坐标(x, y)最大步数n的情况下的路径数
 */
class Solution {
    final static int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[m][n][maxMove + 1];
        for (int[][] i : cache) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, cache);
    
    }
    
    private int helper(int m, int n, int move, int x, int y, int[][][] cache) {
        if (x == -1 || y == -1 || x == m || y == n) {
            return 1;
        }
        if (move <= 0) {
            return 0;
        }
        if (cache[x][y][move] >= 0) {
            return cache[x][y][move];
        }
        return cache[x][y][move] = (((helper(m, n, move - 1, x + 1, y, cache) % MOD + helper(m, n, move - 1, x - 1, y, cache) % MOD) % MOD + helper(m, n, move - 1, x, y + 1, cache) % MOD) % MOD + helper(m, n, move - 1, x, y - 1, cache) % MOD) % MOD;
    }
}