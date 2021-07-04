/**
 * 按照正常进制转换的方法，连除直到商为0
 */
class Solution {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (N == 0) {
                break;
            }
            int res = N % (-2);
            N = N / (-2);
            if (res < 0) {
                res += 2;
                N += 1;
            }
            sb.insert(0, String.valueOf(res));
        }
        return sb.toString();
    }
}