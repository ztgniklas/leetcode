class Solution {
    public int totalFruit(int[] tree) {
        Set<Integer> hs = new HashSet<>();
        int sum=0,i=0,j=0;
        while(i<tree.length && j<tree.length){
            if(hs.contains(tree[j])){
                j++;
            }
            else{
                if(hs.size()<2){                  
                    hs.add(tree[j]);
                    j++;
                }
                else{
                    sum = Math.max(j-i,sum);   
                    i = j-1;
                    while(tree[i]==tree[j-1]){
                        i--;
                    }
                    i++;
                    hs.clear();
                    hs.add(tree[j]);
                    hs.add(tree[j-1]);
                }
                
            }
        }
        
        return Math.max(j-i,sum);
    }
}

/*
sliding windows，two pointers，关键在于两个指针什么时候动。
用set解决类别数的问题
*/