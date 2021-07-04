class Solution {
    public boolean backTrack(int row,int col,int index,String word,char[][] board,int[][] used){
        if(row<0||col<0 || row>=board.length || col>=board[0].length || used[row][col]==1)
            return false;
        if(board[row][col]==word.charAt(index)){
            if(index==word.length()-1)
                return true;
            else{
                used[row][col] = 1;
                if(backTrack(row+1,col,index+1,word,board,used)||
                    backTrack(row-1,col,index+1,word,board,used)||
                    backTrack(row,col+1,index+1,word,board,used)||
                    backTrack(row,col-1,index+1,word,board,used))
                	return true;
                used[row][col] = 0;
                return false;
            }
            
        }
        else
            return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int[][] used = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    for(int[] d1:used){
                        Arrays.fill(d1,0);
                    }
                    if(backTrack(i,j,0,word,board,used))
                        return true;
                }
            }
        }
        return false;
    }
}

/*
backtrack/dfs思想，对每个位置，上下左右地拓展，只要有一个是true就行
因为用过的位置不能再用，所以维护一个二维数组记录每个位置是否被使用
看讨论区有种方法是board[i][j]^=256，由于char是0-255，所以亦或256会得到一个大于255也就是不能表示任何字符的值，相当于标记了脏位。
本体的一个重要点，在于一旦当前位置四个方向都探索失败，在返回前一定将本位置重新标记为未使用。否则在返回后的位置继续进行探索时，一些明明没被使用的位置也可能已经认为被使用。
*/