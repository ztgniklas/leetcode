class Solution {  
    public int numDecodings(String s) {
        if(s.length()==0 || s.equals("0") || s.startsWith("0"))
            return 0;
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            int one = Integer.valueOf(s.substring(i,i+1));
            int two = Integer.valueOf(s.substring(i-1,i+1));
            if(one>=1 && one<=9)
                dp[i] += dp[i-1];
            if(two>=10 && two<=26){
                if(i-2>=0)
                    dp[i] += dp[i-2];
                else
                    dp[i]++;
            }
                
        }
        return dp[s.length()-1];
    }
} 

/*
和上楼梯问题类似
注意前面有0的情况如"01"，结果是0
*/