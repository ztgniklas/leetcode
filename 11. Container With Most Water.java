/**
 * O(n^2) is apparently not the best method, hence we think about
 * O(n) method. What come out is two pointer, presenting current
 * container walls. On the next loop, which side should we move in?
 * we hope to contain maximum water, so at least we should preserve
 * the taller one, and move the shorter one to find out if
 * there will be some tall walls in inside.
 */
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int rst = 0;
        while (l < r) {
            rst = Math.max(rst, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return rst;
    }
}