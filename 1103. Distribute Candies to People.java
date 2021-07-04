/**
 * 模拟法，注意最后candy数不足时的情况
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int[] rst = new int[n];
        Arrays.fill(rst, 0);
        for (int i = 0; candies > 0; i++) {
            rst[i % n] += Math.min(i + 1, candies);
            candies = candies - i - 1;
        }
        return rst;
    }
}