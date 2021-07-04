class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int whole = 1;
        while (whole <= N) {
            whole *= 2;
        }
        return whole - N - 1;
    }
}