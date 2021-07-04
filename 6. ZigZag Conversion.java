/*
创建numRows个StringBuilder，相当于就是字符数组
依次填充，注意斜向上的永远是numRows-2个，sb索引从numRows-2降到1
最后把各个sb连到一起即可
*/
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int j=0;j<numRows;j++){
            sb[j] = new StringBuilder();
        }
        int i = 0;
        char[] c = s.toCharArray();
        while(i<c.length){
            for(int j=0;j<numRows;j++){
                if(i>=c.length)
                    break;
                sb[j].append(c[i]);
                i++;
                
            }
            for(int j=numRows-2;j>0;j--){
                if(i>=c.length)
                    break;
                sb[j].append(c[i]);
                i++;
            }
        }
        for(int j=1;j<numRows;j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}