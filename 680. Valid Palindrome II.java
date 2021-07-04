class Solution {
    public boolean validPalindrome(String s) {
        // abccaba
        int delTimes = 1, start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                String cand1 = s.substring(0, start).concat(s.substring(start + 1));
                String cand2 = s.substring(0, end).concat(s.substring(end + 1));
                if (isValid(cand1) || isValid(cand2)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}