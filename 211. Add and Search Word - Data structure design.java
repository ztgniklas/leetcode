/*
因为涉及到add和search，使用Trie树的数据结构，在遇到.时直接遍历.前结点children中所有存在字符
*/
class WordDictionary {
	private TrieNode root;
    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
        
        public void add(String word, int index) {
            if (index == word.length()) {
                this.isWord = true;
                return;
            }
            if (!children.containsKey(word.charAt(index)))
                children.put(word.charAt(index), new TrieNode());
            children.get(word.charAt(index)).add(word, index + 1);
        }
        
        public boolean find(String word, int index) {
        	if (index == word.length())
                return this.isWord;
            if (word.charAt(index) != '.' && !children.containsKey(word.charAt(index)))
                return false;
            if (word.charAt(index) == '.') {
                for (Character c: children.keySet()) {
                    if (children.get(c).find(word, index + 1))
                        return true;
                }
            }
            else {
                return children.get(word.charAt(index)).find(word, index + 1);
            }
            return false;
        }
                
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.add(word, 0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.find(word, 0);
    }
}