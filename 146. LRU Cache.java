/**
 * 最快捷也是android源码实现LRU的方式是用LinkedHashMap
 * 构造函数的第三个参数指定为true表示开启accessOrder，就满足了LRU的需求
 * 重写removeEldestEntry指定何时删除LRU的元素即可
 */
class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cap;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * 不利用LinkedHashMap，则需要使用双链表
 * 同时维护一个记录key和对应链表节点的map，保证能以O(1)时间复杂度找到指定node
 */
class LRUCache {
    DLNode head, tail;
    int capacity, size;
    Map<Integer, DLNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // key:node
        map = new HashMap<>();
        head = new DLNode(0, 0);
        tail = new DLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // update
        DLNode node = map.get(key);
        removeNode(node);
        linkHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode node = map.get(key);
            node.value = value;
            // update
            removeNode(node);
            linkHead(node);
            return;
        }
        DLNode node = new DLNode(key, value);
        linkHead(node);
        map.put(key, node);
        this.size++;
        if (this.size > this.capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
            this.size--;
        }
    }
    
    // node should exist, and we do not change size nor map here
    private void linkHead(DLNode node) {
        DLNode oldHeadNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldHeadNext;
        oldHeadNext.prev = node;
    }
    
    // node should exist, and we do not change size nor map here
    private void removeNode(DLNode node) {
        DLNode prevN = node.prev, nextN = node.next;
        prevN.next = nextN;
        nextN.prev = prevN;
    }
    
    class DLNode {
        public DLNode prev, next;
        public int key, value;
        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
