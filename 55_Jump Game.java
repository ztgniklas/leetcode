class Solution {
    public boolean canJump(int[] nums) {
        int fri = 0;//farthest reachable index for now
        for(int i=0;i<nums.length;i++){
            if(i>fri)
                return false;
            fri = Math.max(fri,i+nums[i]);            
        }
        
        return true;
        
    }
}
/*
从头到尾遍历数组，维护一个当前能到达的最远的index
如果当前index大于能到达的最远的index，说明这个index无论如何达不到
直接返回false
*/
