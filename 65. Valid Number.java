/**
 * 按规则写代码，以E/e分割两部分，然后分别判断是不是合法的decimal/integer
 * 注意各种corner case
 */
class Solution {
    private static final int DECIMAL = 0;
    private static final int INTEGER = 1;
    
    public boolean isNumber(String s) {
        boolean seenE = false, isCapE = false;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && Character.toLowerCase(c) != 'e') {
                return false;
            }
            if ((c == 'e' || c == 'E')) {
                if (seenE) {
                    return false;
                }
                seenE = true;
                isCapE = c == 'E';
            }
        }
        if (seenE) {
            String[] parts = s.split(isCapE ? "E" : "e");
            if (parts == null || parts.length < 2) {
                return false;
            }
            return isValid(parts[0], DECIMAL) && isValid(parts[1], INTEGER);
        }
        return isValid(s, DECIMAL);
    }
    
    private boolean isValid(String s, int type) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean seenDot = false, seenPM = false, seenDigit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i > 0 || seenPM) {
                    return false;
                }
                seenPM = true;
            } else if (c == '.') {
                if (type == INTEGER || seenDot) {
                    return false;
                }
                seenDot = true;
                if (i > 0 && Character.isDigit(s.charAt(i - 1)) || i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    continue;
                }
                return false;
            } else {
                seenDigit = true;
            }
        }
        return seenDigit;
    }
}