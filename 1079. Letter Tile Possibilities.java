/**
 * 考虑暴力枚举的简化方向
 * 相同字符可以用map存储起来，防止组合出相同的序列
 */
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char tile : tiles.toCharArray()) {
            freq[tile - 'A']++;
        }
        return dfs(freq);
        
    }
    
    private int dfs(int[] freq) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            sum++;
            freq[i]--;
            sum += dfs(freq);
            freq[i]++;
        }
        return sum;
    }
}