/*
用hashmap
*/
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                int tmp = hm.get(i);
                if(tmp+1>nums.length/2)
                    return i;
                hm.put(i,tmp+1);
                
            }
            else{
                hm.put(i,1);
                
            }
        }
        return 0;
    }
}