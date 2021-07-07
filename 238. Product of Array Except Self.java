/**
 * 考虑时间复杂度O(n)和空间复杂度O(1)的方法，那就应该是one path内
 * 解决问题。先计算所有数的乘积，再在遍历到i时除以nums[i]即可
 * 要注意0的情况，不能算在乘积里，并且要关注0的个数
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numOf0 = 0;
        int productWithout0 = 1;
        for (int num : nums) {
            if (num == 0) {
                numOf0++;
            } else {
                productWithout0 *= num;
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (numOf0 > 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = productWithout0 / nums[i];
                }
            } else {
                if (numOf0 > 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = productWithout0;
                }
            }
        }
        return ans;
    }
}