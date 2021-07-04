/*
像这种统计字母的频率的，考虑使用数组
每个单词依次统计下来即可
*/
class Solution {
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);
        for (String str: A) {
            int[] curFreq = new int[26];
            Arrays.fill(curFreq, 0);
            for (char c: str.toCharArray()) {
                curFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.min(freq[i], curFreq[i]);
            }
        }
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                for (int j = 0; j < freq[i]; j++) {
                    rst.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return rst;
    }

}