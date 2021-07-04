/**
 * 与第31题类似
 * 从右至左找到第一个左比右大的位置即为交换之所在
 * 因为是第一个，所以该位置右边的都是从左至右非降序的
 * 从右至左找到其中第一个小于该位置的（连续相等的特殊情况
 * 要左移）交换即为所求
 */
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        // find the 1st pos i that arr[i] > arr[i + 1]
        // from left to right
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                int exPos = i;
                for (int j = arr.length - 1; j >= i; j--) {
                    // as for the consecutive equivalent element,
                    // we choose the one with the least index to
                    // ensure the largest smaller
                    if (j > i && arr[j] == arr[j - 1]) {
                        continue;
                    }
                    // the first position for left to right that is
                    // less than arr[i - 1] is the desired one to swap
                    // with position i - 1
                    if (arr[j] < arr[i - 1]) {
                        exPos = j;
                        break;
                    }
                }
                // swap
                int tmp = arr[i - 1];
                arr[i - 1] = arr[exPos];
                arr[exPos] = tmp;
                return arr;
            }
        }
        return arr;
        
    }
}