class Solution {
    public final static String[] lessThan20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final static String[] tenthDigit = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public final static String[] threeDigitName = new String[] {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        // 1,123,123
        if (num <= 0) {
            return "Zero";
        }
        String rst = "";
        int idx = 0;
        while (num > 0) {
            // 1123
            if (num % 1000 != 0) {
                rst = helper(num % 1000).trim() + " " + threeDigitName[idx] + " " + rst;
            }
            num /= 1000;
            idx++;
        }
        return rst.trim();
    }
    
    // < 1000
    private String helper(int num) {
        if (num < 20) {
            return lessThan20[num];
        } else if (num < 100) {
            return tenthDigit[num / 10 - 2] + " " + helper(num % 10);
        }
        return lessThan20[num / 100] + " Hundred " + helper(num % 100);
    }
}