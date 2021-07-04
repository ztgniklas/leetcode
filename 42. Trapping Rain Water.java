/*
双指针，关注两边矮的，决定了水的容量
*/
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        if (height == null || height.length == 0 ||
            height.length == 1 || height.length == 2)
            return sum;
        
        int lo = 0, hi = height.length - 1;
        while (height[lo] == 0) {
            lo++;
            if (lo >= height.length - 2)
                return sum;
        }
        while (height[hi] == 0) {
            hi--;
            if (hi <= 1 || hi - lo == 1)
                return sum;
        }
        
        int base = -1;
        while (lo < hi) {
        	int lessSide = height[lo] > height[hi] ? hi : lo;
            boolean isLeft = height[lo] > height[hi] ? false : true;
            if (base == -1) {
                base = height[lessSide];
                lessSide += isLeft? 1: -1;
            }
            else {
                if (height[lessSide] < base)
                    sum += base - height[lessSide];
                else
                    base = height[hi] > height[lo] ? height[lo] : height[hi];
                lessSide += isLeft? 1 : -1;
            }
            
            if (isLeft) lo = lessSide;
            else hi = lessSide;
        }
        return sum;
    }
}