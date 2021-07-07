/**
 * 先用dps（暴力法）递归，递归得到当前idx之后的元素能组合成的指定target的
 * 组合数。之后引入memo，记录在特定idx和当前计算得到的数返回的组合方法数，
 * 之后如果遇到一样的情况可以直接取memo中的结果，不用再递归了
 */
class Solution {
    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new int[2001][nums.length + 1];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return helper(nums, target, 0, 0);
    }
    
    private int helper(int[] nums, int target, int idx, int curRst) {
        if (idx == nums.length) {
            return target == curRst ? 1 : 0;
        }
        int cur = nums[idx];
        int minusChoice = 0, plusChoice = 0;
        if (memo[cur + curRst + 1000][idx + 1] != -1) {
            minusChoice = memo[cur + curRst + 1000][idx + 1];
        } else {
            minusChoice = helper(nums, target, idx + 1, curRst + cur);
            memo[cur + curRst + 1000][idx + 1] = minusChoice;
        }
        
        if (memo[curRst - cur + 1000][idx + 1] != -1) {
            plusChoice = memo[curRst - cur + 1000][idx + 1];
        } else {
            plusChoice = helper(nums, target, idx + 1, curRst - cur);
            memo[curRst - cur + 1000][idx + 1] = plusChoice;
        }
        return minusChoice + plusChoice;
    }
}