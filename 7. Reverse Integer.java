/*
取出一位使用/10和%10
注意对溢出的判断，通过rev和tmp就可以判断
注意rev是整数，所以只要大于Integer.MAX_VALUE/10，哪怕只大1，即214748365，rev*10也等于2147483650>2147483647肯定溢出，负数同理
负数取余还是负数，所以不必额外考虑输入值的正负
*/
class Solution {
    public int reverse(int x) {  
        int rev = 0;        
        while(x!=0){
            int tmp = x%10;
            x = x/10;
            if(rev>Integer.MAX_VALUE/10 || rev==Integer.MAX_VALUE/10 && tmp >7)
                return 0;//2147483647
            if(rev<Integer.MIN_VALUE/10 || rev==Integer.MIN_VALUE/10 && tmp<-8)
                return 0;//-2147483648
            rev = rev*10+tmp;
        }        
        return rev;       
    }
}