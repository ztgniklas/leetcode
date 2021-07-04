/*
要求log复杂度，无疑想到二分法
因此关键在于得到mid后，怎么判断去掉哪一半
因为nums序列可能有多个顶点，所以mid的位置有四种情况
1.处于顶点，即左右两边值都比它小，可以直接返回mid即为所求
2.处于谷底，即左右两边值都比它大，根据题意左右两边必然都存在至少一个顶点
3.处于上升序列中，即左边值比它小，右边比它大，则右边必然至少存在一个顶点
4.处于下降序列中，即左边值比它大，右边比它小，则左边必然至少存在一个顶点

这道题leetcode题意不清，lintcode上描述比较清晰，序列至少存在一个顶点，即nums数组中至少存在3个数才合法，而且满足nums[0] < nums[1] 并且 nums[n - 2] > nums[n - 1]，排除了开头下降，结尾上升的情况；满足相邻位置的数字是不同的，排除了出现平台的情况，比如[1,2,2,1]

btw，有相等的数只能O(n)解决
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //at peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            //at bottom
            else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])
                end = mid;
            //among ascending sequence
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                start = mid;
            //among descending sequence
            else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1])
                end = mid;
        }
        
        return nums[start]>nums[end]?start:end;
    }
}