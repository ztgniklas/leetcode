/**
 * 题中已经告知false的情况会出现cycle，所以用hashtable记录之前的数字
 * 一旦有重复的就说明不是happy number
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        while (true) {
            int next = getNext(n);
            if (next == 1) {
                return true;
            }
            if (hs.contains(next)) {
                return false;
            }
            hs.add(next);
            n = next;
        }
    }
    
    private int getNext(int n) {
        int next = 0;
        while (n > 0) {
            next += (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        return next;
    }
}