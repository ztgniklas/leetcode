/*
暴力排序然后逐一对比，时间复杂度O(nlogn)
*/
class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                num++;
            }
        }
        return num;
    }
}

/**
 * O(n)解法，首先统计每种高度的出现次数，然后按高度从低到高的顺序依次查找
 * 如果当前heights[i]的高度不对应出现次数不为0的最低高度
 * 则说明站位不对，否则次数--，继续检查下一个站位
 */
class Solution {
    public int heightChecker(int[] heights) {
        // 0,3,1,1,1
        int[] freq = new int[101];
        Arrays.fill(freq, 0);
        for (int height : heights) {
            freq[height]++;
        }
        int curH = 1, numOfWrong = 0;;
        for (int i = 0; i < heights.length; i++) {
            while(freq[curH] <= 0) {
                curH++;
            }
            freq[curH]--;
            if (heights[i] != curH) {
                numOfWrong++;
            }
        }
        return numOfWrong;
    }
}