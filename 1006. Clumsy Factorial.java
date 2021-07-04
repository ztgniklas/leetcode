/*
找规律，注意n=4的例外情况
从第四个开始，每四个之和为0，最后剩0，1，2，3的情况分别讨论
*/
class Solution {
    public int clumsy(int N) {
        if (N <= 4) {
            switch (N) {
                case 1: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
                case 3: {
                    return 6;
                }
                case 4: {
                    return 7;
                }
            }
        }
        int numOfChunk = (N - 3) / 4;
        int restNum = (N - 3) % 4;
        switch (restNum) {
            case 0: {
                return N - 1;
            }
            case 1: {
                return N + 1;
            }
            case 2: 
            case 3: {
                return N + 2;
                
            }
        }
        return 0;
    }
}