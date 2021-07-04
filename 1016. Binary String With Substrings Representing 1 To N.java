class Solution {
    public boolean queryString(String S, int N) {
        
        for (int i = 1; i <= N; i++) {
            String binaryN = Integer.toBinaryString(i);
            if (!S.contains(binaryN)) {
                return false;
            }
        }
        return true;
    }
}