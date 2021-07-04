/*
前缀树，用数组，递归
*/
class TrieNode {
    private TrieNode[] children;
    private boolean isWord;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.isWord = true;
            return;
        }
        if (this.children[word.charAt(index) - 'a'] == null)
            this.children[word.charAt(index) - 'a'] = new TrieNode();
        this.children[word.charAt(index) - 'a'].insert(word, index + 1);
    }
    
    public boolean search(String word, int index) {
        if (index == word.length()) {
            return this.isWord;
        }
        if (this.children[word.charAt(index) - 'a'] != null) {
            return this.children[word.charAt(index) - 'a'].search(word, index + 1);
        }
        return false;
    }
    
    public boolean startsWith(String prefix, int index) {
        if (index == prefix.length())
            return true;
        if (this.children[prefix.charAt(index) - 'a'] != null) {
            return this.children[prefix.charAt(index) - 'a'].startsWith(prefix, index + 1);

        }
        return false;
    }
}
class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }
}
