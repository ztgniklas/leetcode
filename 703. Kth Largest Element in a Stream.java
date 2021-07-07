/**
 * heap永远只存放前k个大的元素
 */
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        // 8 7 6 | 5 4
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}
