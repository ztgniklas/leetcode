/**
 * 先用map统计词频，再加入堆中
 * 堆中要按要求排序，最后按顺序取k个即可
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> decideOrder(a,b));
        pq.addAll(map.entrySet());
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            rst.add(pq.poll().getKey());
        }
        return rst;
    }
    
    private int decideOrder(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (a.getValue().intValue() == b.getValue().intValue()) {
            String strA = a.getKey(), strB = b.getKey();
            int lenA = strA.length(), lenB = strB.length();
            for (int i = 0; i < Math.min(lenA, lenB); i++) {
                if (strA.charAt(i) != strB.charAt(i)) {
                    return strA.charAt(i) - strB.charAt(i);
                }
            }
            return lenA - lenB;
        }
        return b.getValue().intValue() - a.getValue().intValue();
    }
}