// O(n) solution
// On step s at i-th, [i+1, i + nums[i]] can be reached
// at step s+1. We go through [i+1, i + nums[i]] to get the
// range that can be reached at step s+2.
class Solution {
    public int jump(int[] nums) {
        int maxPos = 0, end = 0, jump = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.min(nums.length - 1, Math.max(maxPos, i + nums[i]));
            if (i == end) {
                end = maxPos;
                jump++;
            }
        }
        return jump - 1;
    }
}