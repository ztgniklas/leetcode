class Solution {
    public double[] sampleStats(int[] count) {
        double[] rst = new double[5];
        
        // min
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                rst[0] = i;
                break;
            }
        }
        
        // max
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0) {
                rst[1] = i;
                break;
            }
        }
        
        // mean
        double sum = 0, numOfSample = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                // might overflow if using int
                sum += (double) count[i] * (double) i;
                numOfSample += count[i];
            }
        }
        rst[2] = sum / numOfSample;
        
        // median
        double tmpNum = 0, lastValidInt = rst[0];
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                tmpNum += count[i];
                // 5 2 = 2.5
                if (tmpNum > numOfSample / 2) {
                    if (numOfSample % 2 != 0) {
                        rst[3] = i;
                    } else {
                        if (tmpNum - count[i] == (int) (numOfSample / 2)) {
                            rst[3] = (double) (i + lastValidInt) / 2;
                        } else {
                            rst[3] = i;
                        }
                    }
                    break;
                }
                lastValidInt = i;
            }
        }
        
        // mode
        int freq = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > freq) {
                freq = count[i];
                rst[4] = i;
            }
        }
        return rst;
    }
}