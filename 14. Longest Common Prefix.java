class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0)
                    return "";
            }
        }
        return prefix;
        
        
    }
}
/*
水平扫描，两个两个比
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length() || strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];        
    }
}

/*
垂直扫描，会在较短字符串出现在数组末尾的情况下比水平扫描更有效率
*/