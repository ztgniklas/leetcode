/*
首先想到用递归，可惜超时了。。
*/
class Solution {
    public int robi(int[] nums,int start){
        if(start>=nums.length)
            return 0;
        if(start==nums.length-1)
            return nums[start];
        int first = nums[start] + robi(nums,start+2);
        int second = nums[start+1] + robi(nums,start+3);
        return Math.max(first,second);
    }
    public int rob(int[] nums) {
        return robi(nums,0);
    }
}

/*
既然超时，那就想到用dp。
实际上基本思路是差不多的。都是看自己加上隔一个数大还是自己挨着的数大，只不过递归是“往后看”，dp是“往前看”
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,0);
        dp[1] = nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp[i] = Math.max(nums[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length];
    }
}