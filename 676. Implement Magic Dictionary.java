/**
 * 可以用Trie树做
 */
class MagicDictionary {
    private Set<String> dictSet;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.dictSet = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            dictSet.add(word);
        }
    }
    
    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            StringBuilder sb = new StringBuilder(searchWord);
            for (int j = 0; j < 26; j++) {
                if ((char) (j + 'a') == searchWord.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, (char) (j + 'a'));
                if (dictSet.contains(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}