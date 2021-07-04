class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        String ss = sb.toString();
        ss = ss.toLowerCase();
        int lo=0,hi=ss.length()-1;
        while(lo<hi){
            if(ss.charAt(lo)!=ss.charAt(hi))
                return false;
            else{
                lo++;
                hi--;
            }
        }
        return true;
        
    }
}

/*
最粗暴的用StringBuilder(s).reverse()就不说了
alphanumeric指的是数字和字母，有Character.isLetterOrDigit判断
*/

public boolean isPalindrome(String s) {
    int lo=0,hi=s.length()-1;
    while(lo<hi){
        while(!Character.isLetterOrDigit(s.charAt(lo))){
            lo++;
            if(lo==s.length())
                return true;
        }
            
        while(!Character.isLetterOrDigit(s.charAt(hi)))
            hi--;
        
        if(s.substring(lo,lo+1).equalsIgnoreCase(s.substring(hi,hi+1))){
            lo++;
            hi--;
        }
        else{
            return false;
        }
    }
    return true;
}

/*
不预先排除大小写和非字母数字字符的影响
需要考虑全是非alphanumeric
两个指针移动要用循环，否则连续超过1个非alphanumeric的情况就不行了
*/