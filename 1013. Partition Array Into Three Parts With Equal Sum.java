/**
 * 注意各种corner case
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        // calculate the sum of all elements in arr
        for (int ele : arr) {
            sum += ele;
        }
        
        // impossible to divide if sum if not divisable by 3
        if (sum % 3 != 0) {
            return false;
        }

        // the sum of each part must equal to sum/3
        int sumOf1Part = sum / 3, tmpSum = 0, finishNum = 0;
        for (int i = 0; i < arr.length; i++) {
            tmpSum += arr[i];
            // indicate the end of a partition
            if (tmpSum == sumOf1Part) {
                tmpSum = 0;
                finishNum++;
            }
        }
        return finishNum >= 3; // '>' is to deal with corner cases such as [0,0,0,0]
    }
}