class Solution {
    public boolean isPalindrome(String s){
        return s.equals(new StringBuffer(s).reverse().toString());
    }
    
    public void backTrack(List<List<String>> all,List<String> partition,int index,String s){
        if(index==s.length()){
            all.add(new ArrayList<>(partition));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                partition.add(s.substring(index,i+1));
                backTrack(all,partition,i+1,s);
                partition.remove(partition.size()-1);
            }
                      
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> all = new ArrayList<>();
        backTrack(all,new ArrayList<String>(),0,s);
        return all;
    }
}

/*
这种遍历所有情况的考虑backtracking（虽然有时会超时。。那就考虑dp）
对于每个索引位置index，考察从index开始s的所有子串，如果是回文，那么s剩下的部分继续backtracking递归，知道index超出范围，说明一种划分情况结束了
这里在加入总的输出结果数组前，不需要判断当前的划分是否为空，因为总是至少存在一种划分成功的情况（一个一个字母）
*/