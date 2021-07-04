/*
和295题类似，一样用堆来解决
窗口的每一次移动都可以分解为增加一个值然后删除一个值
由于堆不提供删除操作（Java的pq删除操作为遍历，时间复杂度为O(n)）
如果希望对的删除操作也为O(logn)，可以使用HashHeap，java中用TreeSet实现
由于TreeSet不能存储重复值，所以定义一个节点类存储位置和对应值，TreeSet加入的是结点。
本体的另一个比较tricky的地方是避免溢出。在求中位数是要先各自除以2在求和，防止先求和可能溢出；另一处是在结点类重写compareTo，不能直接返回两值之差（不能写成 return this.val - other.val），直接比较即可。
*/
class Solution {
    
    class Node implements Comparable<Node> {
        public int id;
        public int val;
        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node other) {
            if (this.val == other.val)
                return this.id - other.id;
            if (this.val > other.val)
            	return 1;
            else
            	return -1;
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> rst = new LinkedList<>();
        TreeSet<Node> leftHeap = new TreeSet<>();
        TreeSet<Node> rightHeap = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            addNum(leftHeap, rightHeap, new Node(i, nums[i]));
        }
        rst.add(findMedian(leftHeap, rightHeap));
        for (int i = 1; i < nums.length - k + 1; i++) {
            addNum(leftHeap, rightHeap, new Node(i + k -1, nums[i + k - 1]));
            deleteNum(leftHeap, rightHeap, new Node(i - 1, nums[i - 1]));
            rst.add(findMedian(leftHeap, rightHeap));
        }
        
        double[] output = new double[rst.size()];
        for (int i = 0; i < rst.size(); i++) {
            output[i] = rst.get(i);
        }
        return output;
                
    }
    
    public void addNum(TreeSet<Node> leftHeap, TreeSet<Node> rightHeap, Node node) {
        if (leftHeap.size() == 0 || node.val <= findMedian(leftHeap, rightHeap)) {
            leftHeap.add(node);
        }
        else
            rightHeap.add(node);
        
        balance(leftHeap, rightHeap);
    }
    
    public void deleteNum(TreeSet<Node> leftHeap, TreeSet<Node> rightHeap, Node node) {
		if (leftHeap.contains(node))
            leftHeap.remove(node);
        else
            rightHeap.remove(node);
        
        balance(leftHeap, rightHeap);
    }
    
    public void balance(TreeSet<Node> leftHeap, TreeSet<Node> rightHeap) {
        if (leftHeap.size() < rightHeap.size()) {
            leftHeap.add(rightHeap.pollFirst());
        }
        else if (leftHeap.size() > rightHeap.size() + 1)
            rightHeap.add(leftHeap.pollLast());
    }
    
    public double findMedian(TreeSet<Node> leftHeap, TreeSet<Node> rightHeap){
        if (leftHeap.size() == rightHeap.size() + 1)
            return leftHeap.last().val;
        else if (leftHeap.size() == rightHeap.size() && leftHeap.size() != 0) 
            return leftHeap.last().val / 2.0 + rightHeap.first().val / 2.0;
        return 0;
    }
}