/**
 * 和数学中求gcd的思想类似
 * 长的string中除去开头和短string一致的子串（如果没有显然就无gcd）
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 < len2) {
            return gcdOfStrings(str2, str1);
        }
        // now len1 >= len2
        if (len2 == 0) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }
    
}