/*
sliding window，两个指针，对所有含0数量不多于K的子串进行比较
*/
class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int length = Integer.MIN_VALUE;
        int tmpK = K;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                tmpK--;
            }
            while (tmpK < 0) {
                if (A[start] == 0) {
                    tmpK++;
                }
                start++;
            }
            length = Math.max(length, end - start + 1);
            
        }
        return length;
    }
}
/*
brute force
*/
/*class Solution {
    public int longestOnes(int[] A, int K) {
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int curLen = 0, tmpK = K;
            int j = i;
            for (; j < A.length; j++) {
                if (A[j] != 1) {
                    if (tmpK == 0) {
                        length = Math.max(length, j - i);
                        break;
                    } else {
                        tmpK--;
                    }
                }
            }
            if (j == A.length) {
                length = Math.max(length, j - i);
            }
        }
        return length;
    }
}*/