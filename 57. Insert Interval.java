/**
 * 遍历的同时，merge数据，在适当的时候加入融合或没融合的newInterval
 * 也可以分三段while处理
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rst = new ArrayList<>();
        boolean isInserted = false, isMerging = false;
        for (int[] itv : intervals) {
            if (isInserted) {
                rst.add(itv);
                continue;
            }
            // not overlap, itv should be added without change
            if (newInterval[1] < itv[0] || newInterval[0] > itv[1]) {
                // if newInterval is merging before, it means the merging should
                // stop, as current itv doesnt overlap with newInterval anymore
                // or there is no merging occuring but cur itv has passed newInterval,
                // it means newInterval should be added directly before cur itv.
                if (isMerging || newInterval[1] < itv[0]) {
                    rst.add(newInterval);
                    isMerging = false;
                    isInserted = true;
                }
                rst.add(itv);
                continue;
            }
            isMerging = true;
            newInterval[0] = Math.min(newInterval[0], itv[0]);
            newInterval[1] = Math.max(newInterval[1], itv[1]);
            
        }
        
        // not inserted yet, merged range still in newInterval, should add at last
        if (!isInserted) {
            rst.add(newInterval);
        }
        return rst.toArray(new int[0][0]);
    }
}