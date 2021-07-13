/**
 * 和Task Scheduler类似，按频次从大到小排列字符，从大到小对每个字符
 * 隔一个放一个，这样能最能保证相同字符不相邻。是否可能排列从最高频次
 * 数和s长度的关系就可以提前判断出
 */
class Solution {
    final static String IMPOSSIBLE = "";
    public String reorganizeString(String s) {
        char[] rst = new char[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().intValue() == b.getValue().intValue() ? a.getKey().compareTo(b.getKey()) : b.getValue().intValue() - a.getValue().intValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        // previously decide possibility
        if (pq.peek().getValue().intValue() * 2 > s.length() + 1) {
            return IMPOSSIBLE;
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curE = pq.poll();
            while (curE.getValue().intValue() > 0) {
                // put into place with one interval
                // [a, , a, , a]
                rst[idx] = curE.getKey();
                curE.setValue(curE.getValue().intValue() - 1);
                idx += 2;
                if (idx >= s.length()) {
                    idx = idx % (s.length() - (1 - s.length() % 2));
                }
            }
        }
        return new String(rst);
    }
}