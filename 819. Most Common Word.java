/**
 * 思路不难，但corner case很多
 * 任意个和任意符号都可以分割word，并不只有空格
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String curWord = null;
        int curFreq = 0;
        List<String> words = split(paragraph);
        for (String word : words) {
            if (!contains(banned, word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (curWord == null || curFreq < map.get(word)) {
                    curWord = word;
                    curFreq = map.get(word);
                }
            }
            
        }
        return curWord;
        
        
    }
    
    private boolean contains(String[] strs, String str) {
        for (String s : strs) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    private List<String> split(String para) {
        List<String> words = new ArrayList<>();
        String cur = "";
        for (char c : para.toCharArray()) {
            if (Character.isLetter(c)) {
                cur = cur.concat(String.valueOf(Character.toLowerCase(c)));
            } else {
                if (!"".equals(cur)) {
                    words.add(cur);
                    cur = "";
                }
            }
        }
        if (!"".equals(cur)) {
            words.add(cur);
            cur = "";
        }
        return words;
    }
}