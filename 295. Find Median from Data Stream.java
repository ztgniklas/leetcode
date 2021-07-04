/*
每加入一次数字就对所有数字排序求中位数，时间复杂度太高
应该以中位数为分界维护左右两个集合，这两个集合不必有序，但左边需要能取最大值，右边能取最小值
这种取集合最大/小值的考虑用堆这一数据结构。左半部分集合用最大堆，右半部分集合用最小堆
左半边元素个数要不等于右半边，要不比右边多1，这样，每次求当前数据流的中位数时，如果有偶数个数据，就可以左边取最大值，右边取最小值，取平均即可；如果是奇数个数据，则直接取左半边最大值即为所求。
每次加入值，判断值与当前中位数的大小关系。小于则加入左半边，大于则加入右半边。当然还要平衡左右两边数量，使左半边元素个数要不等于右半边，要不比右边多1。
*/
class MedianFinder {
	private PriorityQueue<Integer> minHeap, maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y.compareTo(x);
            }
        };
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(revCmp);
    }
    
    public void addNum(int num) {
        if (findMedian() == Double.NaN)
            maxHeap.add(num);
        if (num > findMedian()) {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
        else {
            maxHeap.add(num);
            if (minHeap.size() + 1 < maxHeap.size())
                minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size() && maxHeap.size() != 0) {
            int right = minHeap.poll();
            int left = maxHeap.poll();
            minHeap.add(right);
            maxHeap.add(left);
            return (right + left) / 2.0;
        }
        if (maxHeap.size() - 1 == minHeap.size()) {
            int median = maxHeap.poll();
            maxHeap.add(median);
            return median;
        }
        return Double.NaN;
    }
}