/**
 * 使用-'0'来转换char和int更方便些
 * 不要忘记最后加上carry，如果不为0
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        String rst = "";
        int pt1 = num1.length() - 1, pt2 = num2.length() - 1;
        while (pt1 >= 0 && pt2 >= 0) {
            int sum = Character.digit(num1.charAt(pt1), 10) + Character.digit(num2.charAt(pt2), 10) + carry;
            carry = sum / 10;
            rst = (sum % 10) + rst;
            pt1--;
            pt2--;
        }
        int pt = pt1 >= 0 ? pt1 : pt2;
        String lastNum = pt1 >= 0 ? num1 : num2;
        while (pt >= 0) {
            int sum = Character.digit(lastNum.charAt(pt), 10) + carry;
            carry = sum / 10;
            rst = (sum % 10) + rst;
            pt--;
        }
        if (carry > 0) {
            rst = carry + rst;
        }
        return rst;
    }
}