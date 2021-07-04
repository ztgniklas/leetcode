/**
 * 首先将nums从小到大排序
 * 对于i, j, k (i < j < k)
 * 暂时固定k，看i和j。显然只要保证nums[i] + nums[j] > nums[k]就可以构成三角形
 * 如果可以构成，说明i的取值范围可以从i到j-1，下一步可以减少k；否则还要增加i
 * 这样可以将时间复杂度从暴力枚举的O(n^3)降低到O(n^2)
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            int start = 0, end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    sum += end - start;
                    end--;
                } else {
                    start++;
                }
            }
            
        }
        return sum;
    }
    
}