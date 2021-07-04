class Solution {
    public void reverseString(char[] s) {
        int lo=0,hi=s.length-1;
        while(lo<hi){
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
}

/*
也可以一个指针，遍历s.length/2次，因为对称的位置是s.length-i-1
*/