/**
 * prefix，遍历到位置i，就保存当前和除以k取余的结果，如果之后取余发现
 * 余数已被存储，则说明存在。我们还要保存获取这个余数的索引，只有当当前
 * 索引比它至少后两位才行，因为题意是至少两个连续。
 * 要注意几种corner case，比如:
 * 连续0的情况，连续单个是倍数的情况
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(){{put(0, -1);}};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (map.containsKey(sum % k)) {
                if (i - map.get(sum % k) > 1) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
            
        }
        return false;
    }
}