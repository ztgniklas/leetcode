/**
 * O(n^2)会TLE，考虑O(n)的方法
 * 遍历每个num的第i位，如果有k个为1，总共n个num，则
 * 对于这一位的总汉明距离是k * (n - k)
 * 这样，因为32位整型位数是固定的，所以时间复杂度是O(32n) = O(n)
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            int oneCnt = 0;
            for (int num : nums) {
                oneCnt += (num >> i) & 1;
            }
            rst += oneCnt * (nums.length - oneCnt);
        }
        return rst;
    }
}