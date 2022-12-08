/**
 * The O(n^2) solution that starting at each char in the string,
 * then finding the longest non-repeated substring is apparently
 * not the best solution. We look for an O(n) solution.
 * 
 * When we find a repeated char in a substring, the only thing
 * we need to do is shortening the substring from the start. When
 * we find the char that is the same as the current end, the shortening
 * should end. And now we move forward the end of the substring to find
 * the longest one. That's a sliding window or two pointer method.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = Integer.MIN_VALUE;
        Set<Character> hs = new HashSet<>();
        while (right < s.length()) {
            if (!hs.contains(s.charAt(right))) {
                hs.add(s.charAt(right));
                right++;
            } else {
                len = Math.max(len, right - left);
                while (left < right) {
                    if (s.charAt(left) == s.charAt(right)) {
                        hs.remove(s.charAt(left));
                        left++;
                        break;
                    } else {
                        hs.remove(s.charAt(left));
                        left++;
                    }
                }
            }
        }
        return Math.max(len, right - left);
    }
}