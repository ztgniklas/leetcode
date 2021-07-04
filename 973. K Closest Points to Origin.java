/**
 * 使用heap，并重写compare方法。最后取出k个即可
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] rst = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] == b[0] && a[1] == b[1] ? -1 : (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });
        for (int[] point : points) {
            pq.offer(point);
        }
        for (int i = 0; i < k; i++) {
            rst[i] = pq.poll();
        }
        return rst;
    }
}