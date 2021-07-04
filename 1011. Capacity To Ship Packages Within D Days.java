class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int start = weights[0], end = 0;
        
        for (int w: weights) {
            start = Math.max(start, w);
            end += w;
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int days = divide(weights, mid);
            if (days > D) {
                start = mid;
            } else if (days <= D) {
                end = mid;
            } 
        }
        int daysStart = divide(weights, start);
        int daysEnd = divide(weights, end);
        if (daysStart <= D) {
            return start;
        } else {
            return end;
        }
    }
    
    private int divide(int[] weights, int maxW) {
        int days = 0, curW = 0;
        for (int w: weights) {
            if (curW + w > maxW) {
                days++;
                curW = w;
            } else {
                curW += w;
            }
        }
        return days + 1;
    }
}