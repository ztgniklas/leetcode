/**
 * 可以用遍历获取最小值，因此思考O(logn)时间的方法
 * 该时间复杂度下基本只有二分法。由于这是一个经过旋转的数组
 * 因此每次要确定继续检查哪个半边，需要先判断mid在截断点的左边还是右边
 * 例如[4,5,6,1,2,3]中6和1就是截断点
 */
class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[end]) {
                if (nums[mid] >= nums[start]) {
                    // mid at bigger subarray
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                // current subarray is already ascending
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}