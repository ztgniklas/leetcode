/**
 * 要确保频次最多的任务相隔尽可能远的距离，这样才能尽最大可能确保少使
 * CPU闲置。因此每一轮依次取出当前频次最多的任务，每一轮结束后如果发现
 * 任务数量不满n+1，则不得不用闲置补足
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() == a.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        
        int num = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> toOfferBack = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                if (entry.getValue() > 1) {
                    entry.setValue(entry.getValue() - 1);
                    toOfferBack.add(entry);
                }
                num++;
                k--;
            }
            for (Map.Entry<Character, Integer> entry : toOfferBack) {
                pq.offer(entry);
            }
            if (!pq.isEmpty()) {
               num += k; 
            }
            
        }
        return num;
    }
}