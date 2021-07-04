/**
 * 这个解法和股票涨跌那个题相似
 * 统计变化（今天相比昨天增加/减少多少），于是今天的数量就是昨天加上变化量
 * 时间复杂度为O(m+n) m为booking数量
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] rst = new int[n], change = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0], last = booking[1], seats = booking[2];
            change[first - 1] += seats;
            if (last <= n - 1) {
                change[last] -= seats;
            }
            
        }
        rst[0] += change[0];
        for (int i = 1; i < n; i++) {
            rst[i] += rst[i - 1] + change[i];
        }
        return rst;
    }
}

/**
 * 直接统计每一天有多少座位
 * 时间复杂度较高，为O(m*n) m为booking数量
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] rst = new int[n];
        Arrays.fill(rst, 0);
        for (int[] booking : bookings) {
            int first = booking[0], last = booking[1], seats = booking[2];
            for (int i = first; i <= last; i++) {
                rst[i - 1] += seats;
            }
        }
        return rst;
    }
}