/**
 * Integer.toBinaryString转换为二进制
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        char flag = '0';
        String binaryN = Integer.toBinaryString(n);
        for (int i = 0; i < binaryN.length(); i++) {
            if (i == 0) {
                flag = binaryN.charAt(i);
                continue;
            }
            if (binaryN.charAt(i) == flag) {
                return false;
            }
            flag = binaryN.charAt(i);
        }
        return true;
    }
}