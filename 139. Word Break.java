/*
首先想到的依旧是递归的backtracking
思路是在当前index之前的已经确定能够被字典划分，依次遍历之后的子串，如果发现是字典的词，就把剩下的部分递归重复以上过程
不过又是超时了。。不出所料又是一道用dp的题
*/
class Solution { //此方法无法通过测试！！
    public boolean backTrack(int index,String s,List<String> wordDict){
        if(wordDict.contains(s.substring(index)))
            return true;
        boolean rst=false;
        for(int i=index+1;i<s.length();i++){
            if(wordDict.contains(s.substring(index,i)))
                rst = rst || backTrack(i,s,wordDict);
        }
        return rst;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrack(0,s,wordDict);
    }
}

/*
使用dp方法。
思路是dp[i]表示索引i即i之前的子串是否可以被字典划分
因此对于当前索引j，要判断j之前的每个位置i的dp[i]，如果为true，再判断i到j的子串是否属于字典的词；如果不属于，就判断s[0:j+1]是不是整个属于字典的词，即：dp[j]=dp[i]&&dict.contains(s[i+1,j+1])||dict.contains(s[0:j+1])
对s[0:j+1]的判断无关乎i，所以在写代码的时候移到第二层循环之外，可以提升算法性能
*/
class Solution {  
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp,false);
        if(wordDict.contains(s.substring(0,1)))
            dp[0]=true;
        for(int j=1;j<s.length();j++){
            if(wordDict.contains(s.substring(0,j+1))){
                dp[j] = true;
                continue;
            }               
            for(int i=0;i<j;i++){
                if(dp[i]&&wordDict.contains(s.substring(i+1,j+1))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()-1];
    }
}