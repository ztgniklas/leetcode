/*
把6种两两组合的情况单独考虑，其他的直接用map即可
*/
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);hm.put('V',5);hm.put('X',10);
        hm.put('L',50);hm.put('C',100);hm.put('D',500);
        hm.put('M',1000);
        
        char[] charS = s.toCharArray();
        int rst = 0;
        for(int i=0;i<charS.length;i++){
            if(charS[i]=='I' && i+1<charS.length && charS[i+1]=='V'){
                rst += 4;
                i++;
            }
            else if(charS[i]=='I' && i+1<charS.length && charS[i+1]=='X'){
                rst += 9;
                i++;
            }
            else if(charS[i]=='X' && i+1<charS.length && charS[i+1]=='L'){
                rst += 40;
                i++;
            }
            else if(charS[i]=='X' && i+1<charS.length && charS[i+1]=='C'){
                rst += 90;
                i++;
            }
            else if(charS[i]=='C' && i+1<charS.length && charS[i+1]=='D'){
                rst += 400;
                i++;
            }
            else if(charS[i]=='C' && i+1<charS.length && charS[i+1]=='M'){
                rst += 900;
                i++;
            }
            else{
                rst += hm.get(charS[i]);
            }
                
        }
        return rst;
    }
}