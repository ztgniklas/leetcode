/**
 * brute-force会超时，考虑O(n)时间复杂度
 * 可以维护一个集合，保存当前左右两个子串所包含字符，当
 * 索引向后移动，只需增加、删除索引所指的字符，快速判断
 * 左右两个子串的包含的不同字符数量，在one path下即可完成统计
 */
class Solution {
    public int numSplits(String s) {
        int num = 0;
        Map<Character, Integer> mapL = new HashMap<>(), mapR = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapR.put(c, mapR.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            mapL.put(s.charAt(i), mapL.getOrDefault(s.charAt(i), 0) + 1);
            mapR.put(s.charAt(i), mapR.get(s.charAt(i)) - 1);
            if (mapR.get(s.charAt(i)) == 0) {
                mapR.remove(s.charAt(i));
            }
            if (mapL.size() == mapR.size()) {
                num++;
            }
        }
        return num;
    }
}