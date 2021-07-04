/**
 * 本题的规律在于，经过若干次列翻转后能相同的行（如全0），其在翻转前必定也相同；
 * 而翻转后相反的行（全1对全0），其翻转前必定也完全相反
 * 因此只需要统计翻转前完全相同+完全相反的行的数量
 */
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            String key = genKey(row), rKey = genKey(genReverseArr(row));
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else if (map.containsKey(rKey)) {
                map.put(rKey, map.get(rKey) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        int num = Integer.MIN_VALUE;
        for (int n : map.values()) {
            num = Math.max(n, num);
        }
        return num;
    }
    
    private String genKey(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int ele : arr) {
            sb.append(ele);
        }
        return sb.toString();
    }
    
    private int[] genReverseArr(int[] arr) {
        int[] rArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rArr[i] = 1 - arr[i];
        }
        return rArr;
    }
}