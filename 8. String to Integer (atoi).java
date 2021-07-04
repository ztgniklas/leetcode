/*
基本思想和第7题类似，但是判断负数溢出时要注意，直接-Integer.MIN_VALUE/10本身就会直接溢出，因为-Integer.MIN_VALUE==Integer.MAX_VALUE+1，因此要换一种写法；
这个题有繁多的情况要考虑到，因此有大量的if-else判断句
*/
class Solution {
    public int myAtoi(String str) {
        boolean isNeg = false; //标记是不是负数
        //去除前面的空格
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                str = str.substring(i);
                break;
            }                          
        }
        //判断当前串是否为空，过滤类似"    "的情况
        if(str.length()==0)
            return 0;
        //判断是否有正负号
        if(str.charAt(0)=='-'){
            isNeg = true;
            str = str.substring(1);
        }
        else if(str.charAt(0)=='+')
            str = str.substring(1);
        //判断正负号后面还有没有内容，过滤类似"+"或"-"的情况
        if(str.length()==0)
            return 0; 
        int rst = 0;
        //通常情况，从最高位开始取，然后挪位指导遍历到非数字停止
        if('0'<=str.charAt(0) && str.charAt(0)<='9'){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    int tmp = (int)(str.charAt(i)-'0');
                    if(!isNeg && (rst>Integer.MAX_VALUE/10 || rst==Integer.MAX_VALUE/10 && tmp>7))
                        return Integer.MAX_VALUE;
                    if(isNeg && (-rst<Integer.MIN_VALUE/10 || 0==rst+Integer.MIN_VALUE/10 && tmp>8))
                        return Integer.MIN_VALUE;
                    rst = rst*10 + tmp;
                }
                else break;
            }
        }
        //开头不是数字，直接返回0，过滤类似"word 123"、"-r"的情况
        else
            return 0;

        //根据判断的正负返回结果
        if(isNeg)
            return -rst;
        else
            return rst;
          
        
    }
}