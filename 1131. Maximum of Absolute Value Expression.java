class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int maxVal = Integer.MIN_VALUE;
        int[] par = {1, -1};
        for (int p : par) {
            for (int q : par) {
                int min = p * arr1[0] + q * arr2[0] + 0;
                for (int i = 1; i < arr1.length; i++) {
                    int cur = p * arr1[i] + q * arr2[i] + i;
                    maxVal = Math.max(maxVal, cur - min);
                    min = Math.min(min, cur);
                }
            }
        }
        return maxVal;
    }
    
}