class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char c : order.toCharArray()) {
            map.put(c, idx);
            idx++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSorted(String prev, String next, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(prev.length(), next.length()); i++) {
            char prevC = prev.charAt(i), nextC = next.charAt(i);
            if (prevC != nextC) {
                return map.get(prevC).intValue() < map.get(nextC).intValue();
            }
        }
        return prev.length() <= next.length();
    }
}