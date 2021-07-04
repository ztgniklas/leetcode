/*
排序直接找。不过显然这道题是不想让人这么做的。。。
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

