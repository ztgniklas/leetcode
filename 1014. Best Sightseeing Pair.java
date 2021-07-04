/**
 * dp
 * 暴力枚举的O(n^2)方法超时，思考one path的方法
 * 对于每个给定的i作为第一个spot，它能获得的最大score是
 * maxScore[i] = values[i] + i + max(values[i + 1] - (i + 1), ..., values[n - 1] - (n - 1))
 * i已经给定，不能修改，我们关注后面一部分，令
 * maxEnd[i] = max(values[i + 1] - (i + 1), ..., values[n - 1] - (n - 1))
 *           = max(maxEnd[i + 1], values[i + 1] - (i + 1))
 * 由此，我们可以从后往前求得maxEnd数组，即可在依次遍历后得到
 * 最大score = max(maxScore[0], ..., maxScore[n - 1])
 */
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, rst = Integer.MIN_VALUE;
        int[] maxEnd = new int[n];
        maxEnd[n - 1] = values[n - 1] - n + 1;
        for (int i = n - 2; i >= 0; i--) {
            maxEnd[i] = Math.max(maxEnd[i + 1], values[i + 1] - i - 1);
        }
        
        for (int i = 0; i < n - 1; i++) {
            int curMaxScore = values[i] + i + maxEnd[i];
            rst = Math.max(rst, curMaxScore);
        }
        return rst;
    }
}