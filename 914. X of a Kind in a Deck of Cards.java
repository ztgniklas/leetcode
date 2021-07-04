/*
由于题目规定了deck[i]的最大值为10000，所以可以建立10000大小的数组
不过下面使用Map提供了更一般的解法（当然运行时间较长）
题目的本质就是求最大公约数
*/
class Solution {
    public int getGCD(int a,int b){
        int large = Math.max(a,b);
        int small = Math.min(a,b);
        if(small==0)
            return large;
        return getGCD(small,large%small);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==0 || deck.length==1)
            return false;
        //Arrays.sort(deck);
        Map<Integer,Integer> hm = new HashMap<>();
        int cur = deck[0];
        int fir=0,sec=0;
        for(int i=0;i<deck.length;i++){
            if(!hm.containsKey(deck[i])){
                hm.put(deck[i],1);
            }
            else{
                int tmp = hm.get(deck[i]);
                hm.put(deck[i],++tmp);
            }
        }
        Set<Integer> ks = hm.keySet();
        int gcd = 0;
        for(Integer i:ks){
            if(hm.get(i)==1)
                return false;
            gcd = getGCD(hm.get(i),gcd);
        }
        return (gcd>=2);
        
    }
}