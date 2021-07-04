/**
 * 用map记录相同domino的频次
 * 关注点在如何让map认为[1,2]和[2,1]是相同的key
 * 可以使用字符串形如"1 2"，也可以计算得数值21
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int[] domino : dominoes) {
            String dominoStr = Math.min(domino[0], domino[1]) + " " +
                Math.max(domino[0], domino[1]);
            map.put(dominoStr, map.getOrDefault(dominoStr, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq > 1) {
                sum += freq * (freq -1) / 2;
            }
        }
        return sum;
    }
}