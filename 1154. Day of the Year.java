/**
 * 计算每月累积天数，加上DD的天数，最后判断leap year即可
 */
class Solution {
    public int dayOfYear(String date) {
        String[] ymd = date.split("-");
        int year = Integer.valueOf(ymd[0]), month = Integer.valueOf(ymd[1]), day = Integer.valueOf(ymd[2]);
        int[] daysOfM = new int[] {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int rst = 0;
        if (month > 1) {
            rst += daysOfM[month - 2];
        }
        
        if (month > 2 && year % 4 == 0) {
            rst++;
        }
        rst += day;
        return rst;
    }
}