/*
算得上是二分法的终极应用
关键点还是在于得到mid后怎么判断该取哪一半
显然mid的位置有两种情况，一种在上半部分，一种在下半部分（因为数组在开始到原来排序数组最大值这段是值较大的，所以称为上半部分，另一半成为下半部分）
在上半部分时，如果target > nums[mid] || target < nums[start]，则取右半部分，如果nums[start] <= target < nums[mid]，则取左半部分。下半部分同理可得

这个题的关键点是target不仅要和mid的值比较，还要和终点（起点）比较才能确定取哪一半。画图有助于本题的理解
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        
        int start = 0, end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //at up half part
            if (nums[mid] >= nums[start]) {
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] > target && nums[start] <= target)
                    end = mid;
                else if (nums[mid] < target || nums[start] > target)
                    start = mid;
            }
            // at down half part
            else {
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] < target && nums[end] >= target)
                    start = mid;
                else if (nums[mid] > target || nums[end] < target)
                    end = mid;              
            }
        }
        
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;
        return -1;
    }
}