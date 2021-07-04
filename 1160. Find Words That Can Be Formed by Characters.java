class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String word : words) {
            Map<Character, Integer> mapC = new HashMap<>(map);
            boolean isGood = true;
            for (char c : word.toCharArray()) {
                if (!mapC.containsKey(c) || mapC.get(c) == 0) {
                    isGood = false;
                    break;
                }A
                mapC.put(c, mapC.get(c) - 1);
            }
            if (isGood) {
                sum += word.length();
            }
        }
        return sum;
    }
}