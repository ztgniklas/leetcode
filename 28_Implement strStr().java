class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        for(int i=0;i<haystack.length();i++){
            if(i+needle.length()>haystack.length())
                break;
            for(int j=0;j<haystack.length();j++){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    if(j == needle.length()-1)
                        return i;
                }
                else{
                    break;
                }
            }
        }
        return -1;
    }
}

/*
注意第九行i+j的运用，就像needle在向右移动haystack使用i+j既能记录i又能保证与needle当前进度的对齐
当needle为空串""时，为什么返回0而不是-1？
"abc"可认为是""+"abc"，要求needle第一次出现的索引，所以返回0；
另外，为了保证r=s.indexOf("b");s.substring(r, r + b.length)==b在b为空串时也能成立，所以返回0
*/
