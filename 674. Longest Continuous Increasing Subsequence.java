class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1, curLen = 0, lastNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lastNum) {
                curLen++;
                lastNum = nums[i];
            } else {
                len = Math.max(len, curLen);
                lastNum = nums[i];
                curLen = 1;
            }
        }
        return Math.max(len, curLen);
    }
}