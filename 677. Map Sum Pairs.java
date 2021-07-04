/**
 * 找共同前缀问题，使用Trie树解决
 * 在添加单词时，要在经过的节点累加值
 * 注意如果插入相同的单词，要求覆盖之前值，但是我们算的是累加
 * 所以需要存储已经插入过的所有单词及其val，一旦需要覆盖，我
 * 们计算一个offset作为这次给Trie树add操作的val。
 * 比如，之前已经存储过["apple": 3]，再次insert["apple": 2]时，
 * 我们传给Trie树的值不是2了，而是2-3=-1，这样就实现了覆盖旧值的效果
 */
class MapSum {
    private TrieNode root;
    private Map<String, Integer> savedWords;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
        savedWords = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int realVal;
        // we should override the value if the key
        // has been saved before. here we calculate
        // the offset as the real value input, since
        // we accumulate values in TrieNode
        if (savedWords.containsKey(key)) {
            realVal = val - savedWords.get(key);
        } else {
            realVal = val;
        }
        savedWords.put(key, val);
        root.add(key, 0, realVal);
    }
    
    public int sum(String prefix) {
        return root.search(prefix, 0);
    }
    
    class TrieNode {
        public Map<Character, TrieNode> children;
        public int sum;
        
        public TrieNode() {
            children = new HashMap<>();
            sum = 0;
        }
        
        public void add(String word, int index, int val) {
            if (word.length() == index) {
                return;
            }
            if (!children.containsKey(word.charAt(index))) {
                children.put(word.charAt(index), new TrieNode());
            }
            TrieNode next = children.get(word.charAt(index));
            // accumulate the value of every word that goes through this node
            next.sum += val;
            next.add(word, index + 1, val);
        }
        
        public int search(String word, int index) {
            if (word.length() == index) {
                return sum;
            }
            if (!children.containsKey(word.charAt(index))) {
                return 0;
            }
            TrieNode next = children.get(word.charAt(index));
            return next.search(word, index + 1);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */