/**
 * 和576题的思路很像
 * 最开始先考虑用纯dfs做，结果TLE
 * 因此考虑记录之前计算过的在特定step的最小cost（dp思想）
 */
class Solution {
    int minCost = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dfs(cost, 0, cache), dfs(cost, 1, cache));
    }
    
    private int dfs(int[] cost, int step, int[] cache) {
        if (step >= cost.length) {
            return 0;
        }
        if (cache[step] >= 0) {
            return cache[step];
        }
        return cache[step] = Math.min(dfs(cost, step + 1, cache), dfs(cost, step + 2, cache)) + cost[step];
    }
}