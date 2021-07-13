/**
 * 每一位异或即可
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            rst += (x >> i) & 1 ^ ((y >> i) & 1);
        }
        return rst;
    }
}

/**
 * 使用Integer.bitCount(int a)可以统计a的二进制有多少位为1
 * 两数直接异或即可
 * 两个方法耗时一样
 */
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}