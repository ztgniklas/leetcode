/**
 * 考虑a比b长或等长，可能出现a="abcd" b="da"的情况，所以需要看重复一次和两次
 * 如果b比a长，观察例子a="abcd" b="cdabcdab"可得出经验结论，将a重复至比b长或等长，
 * 比较这两种情况即可
 */
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if ("".equals(b)) {
            return 0;
        }
        int lenA = a.length(), lenB = b.length();
        String newA = a;
        if (lenA >= lenB) {
            if (a.contains(b)) {
                return 1;
            } else if (newA.concat(a).contains(b)) {
                return 2;
            } else {
                return -1;
            }
        }
        int repeatedTimes = (int) Math.ceil((double) lenB / lenA);
        for (int i = 1; i < repeatedTimes; i++) {
            newA = newA.concat(a);
        }
        if (newA.contains(b)) {
            return repeatedTimes;
        } else {
            repeatedTimes++;
            newA = newA.concat(a);
            if (newA.contains(b)) {
                return repeatedTimes;
            }
        }
        return -1;
        
    }
}