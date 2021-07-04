/*
这题直觉用dp，但实际上没有那么明显
硬要用dp表示的话，那么dp[i]就是i及i之前的（必须包括i）subarray的乘积最大值
因此dp[nums.length-1]并不一定是所求
这道题的关键在于处理负值，因为负负得正，所以我们不仅要存储之前的最大值，还要存储最小值，防止之前的为负的最小值乘上为负的nums[i]反而成为了最大值。
因此对于nums[i]，我们要取max(nums[i],nums[i]*max,nums[i]*min)为新的最大值，取min(nums[i],nums[i]*max,nums[i]*min)为新的最小值
*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        int min=nums[0],max=nums[0],rst=max;
        for(int i=1;i<nums.length;i++){
            int premax = max;
            max = Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i],Math.min(nums[i]*premax,nums[i]*min));
            rst = Math.max(rst,max);
        }
        return rst;
    }
}