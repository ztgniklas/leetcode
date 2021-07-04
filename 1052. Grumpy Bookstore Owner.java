/**
 * brute-force解法，遍历所有可能的X持续的位置
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < customers.length - X + 1; i++) {
            int sum = 0;
            for (int j = 0; j < customers.length; j++) {
                if (j >= i && j < i + X) {
                    sum += customers[j];
                } else {
                    sum += customers[j] * (1 - grumpy[j]);
                }
            }
            rst = Math.max(rst, sum);
         }
        return rst;
    }
}

/**
 * sliding window
 * 只用遍历一遍，O(n)时间复杂度
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int numOfMin = customers.length, oriSatisfiedNum = 0;
        // calculate the original number of satisfied customers
        // without using the technique
        for (int i = 0; i < numOfMin; i++) {
            oriSatisfiedNum += customers[i] * (1 - grumpy[i]);
        }

        // one path going through the array. Try every possible
        // position you can put X-minutes period in and calculate
        // the increased number of satisfied customers under the technique.
        // get the original number add the max of increasement of those possibilities
        int incSatisfiedNum = 0;
        for (int i = 0; i < numOfMin - X + 1; i++) {
            int tmp = 0, start = i;
            for (int j = X; j > 0; j--) {
                tmp += grumpy[start] == 1 ? customers[start] : 0;
                start++;
            }
            incSatisfiedNum = Math.max(incSatisfiedNum, tmp);
        }
        return oriSatisfiedNum + incSatisfiedNum;
    }
}