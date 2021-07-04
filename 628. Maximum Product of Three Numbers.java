/**
 * 考虑到数组中可能存在负数，排序后的数组可能的三个数最大乘积
 * 只会出现在最大三个数nums[n - 3] * nums[n - 1] * nums[n - 2]
 * 或者nums[0] * nums[1] * nums[n - 1] 可能两个负数一个整数的情况中间
 */
class Solution {
    public int maximumProduct(int[] nums) {
        // -1 0 1 2 3
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 1] * nums[n - 2]);
    }
}