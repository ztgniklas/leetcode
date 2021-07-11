/**
 * 主要解决如何在one-path内同时识别升序降序
 */
class Solution {
    final static int NOT_DECIDED = 0;
    final static int INCREASE = 1;
    final static int DECREASE = 2;
    public boolean isMonotonic(int[] nums) {
        int prev = nums[0];
        int mono = NOT_DECIDED;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                prev = nums[i];
            } else if (nums[i] > prev) {
                if (mono == DECREASE) {
                    return false;
                } else {
                    mono = INCREASE;
                    prev = nums[i];
                }
            } else {
                if (mono == INCREASE) {
                    return false;
                } else {
                    mono = DECREASE;
                    prev = nums[i];
                }
            }
        }
        return true;
    }
}

/**
 * 还可以分别记录increase和descrease，相当于把一轮只检查是否是升序，一轮只检查是否是
 * 降序糅合到一起，在每次循环末尾检查isInc && isDec，为true则说明不是monotonic，提前返回
 */
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isInc = false, isDec = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isInc = true;
            } else if (nums[i] > nums[i + 1]) {
                isDec = true;
            }
            if (isInc && isDec) {
                return false;
            }
        }
        return true;
    }
}