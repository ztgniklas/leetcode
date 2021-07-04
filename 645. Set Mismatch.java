class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int[] rst = new int[2];
        for (int num : nums) {
            if (hs.contains(num)) {
                rst[0] = num;
            }
            hs.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hs.contains(i)) {
                rst[1] = i;
                break;
            }
        }
        return rst;
    }
}