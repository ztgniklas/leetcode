/**
 * 首先统计每种bar的出现频次，按照频次由大到小，先放入奇数索引位置
 * 再放入偶数索引位置（或者反过来无所谓）。因为必有解，所以无需再做多余判断
 * 一定要先放频次高的，否则不一定能够得到正确解
 * 比如[2,2,1,3]，一解为[2,1,2,3]，但如果不按频次随机选择，可能先放1，再放2
 * 导致出现[1,2,2,3]这样的错误解
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> bar2Freq = new HashMap<>();
        for (int bar : barcodes) {
            bar2Freq.put(bar, bar2Freq.getOrDefault(bar, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue();
        });
        for (Map.Entry entry : bar2Freq.entrySet()) {
            pq.offer(entry);
        }
        int[] rst = new int[barcodes.length];
        int idx = 0;
        Map.Entry<Integer, Integer> curEntry = null;
        while (idx < barcodes.length) {
            if (curEntry == null || curEntry.getValue() <= 0) {
                curEntry = pq.poll();
            }
            
            rst[idx] = curEntry.getKey();
            idx += 2;
            curEntry.setValue(curEntry.getValue() - 1);
        }
        idx = 1;
        while (idx < barcodes.length) {
            if (curEntry == null || curEntry.getValue() <= 0) {
                curEntry = pq.poll();
            }
            
            rst[idx] = curEntry.getKey();
            idx += 2;
            curEntry.setValue(curEntry.getValue() - 1);
        }
        return rst;
    }
}