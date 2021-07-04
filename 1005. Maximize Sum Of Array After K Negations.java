/*
贪心算法：无论正负，每次取反一定取当前的最小值
因为每次都取最小值，考虑堆的数据结构
*/
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele: A) {
            pq.add(ele);
        }
        for (int i = 0; i < K; i++) {
            pq.add(-pq.poll());
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
    
}