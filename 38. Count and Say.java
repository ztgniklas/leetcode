/*
这题的描述相当不清晰。。
实际上就是下一个序列是上一个序列中连续相同的数字的个数与该数字的组合
比如确定1211的下一个序列
首先，有1个1，所以下一序列对应这部分为11（个数+数字）
有1个2，所以下一序列对应这部分为12
最后有2个连续1，所以下一序列对应这部分为21
最后结果是111221
因此，我们只需统计序列中连续数字的个数，再append数字自己，即可得出下一序列
*/
class Solution {
    public String countAndSay(int n) {
        String curSeq = "1";
        
        for(int i=2;i<=n;i++){
            char curChar = curSeq.charAt(0);
            int sum=0;
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<curSeq.length();j++){
                if(curChar==curSeq.charAt(j)){
                    sum++;
                }
                else{
                    sb.append(sum);
                    sb.append(curChar);
                    curChar=curSeq.charAt(j);
                    sum = 1;
                }
            }
            sb.append(sum);
            sb.append(curChar);
            curSeq = sb.toString();
        }
        return curSeq;
    }
}