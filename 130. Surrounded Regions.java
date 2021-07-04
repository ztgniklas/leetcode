/*
第一种思路和200题小岛数量很类似，只不过这里联通的O一旦接触边缘就不能被填充为X。
因此直接暴力地先把这一类不能填X的O区域先填成另外的字母，比如A，这样遍历一遍board的四个边之后，就只剩下那些完全被X包裹的O，再用小岛问题的解法填成X。最后把那些A再填回O
下面是实现代码。由于填A和填X过程一样，所以写成了同一个函数，只不过在填A时，因为最后还要再填回O，所以建立list记录下这些位置，省得最后还要再全部遍历一遍board。
*/
class Solution {
    List<int[]> edge = new ArrayList<>();
    public void SearchAndFlip(char[][] board,int row, int col,char letter){
        if(row>=0 && row<=board.length-1 && col>=0 && 
           col<=board[0].length-1 && board[row][col]=='O'){
            board[row][col] = letter;
            if(letter=='A')
                edge.add(new int[]{row,col});
            SearchAndFlip(board,row+1,col,letter);
            SearchAndFlip(board,row-1,col,letter);
            SearchAndFlip(board,row,col+1,letter);
            SearchAndFlip(board,row,col-1,letter);
        }
    }
    
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0)
            return;
        for(int i=0;i<board.length-1;i++){           
            if(board[i][0]=='O'){
                SearchAndFlip(board,i,0,'A');
            }
            if(board[i][board[0].length-1]=='O'){
                SearchAndFlip(board,i,board[0].length-1,'A');
            }            
        }
        for(int i=0;i<board[0].length-1;i++){           
            if(board[0][i]=='O'){
                SearchAndFlip(board,0,i,'A');
            }
            if(board[board.length-1][i]=='O'){
                SearchAndFlip(board,board.length-1,i,'A');
            }            
        }
        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[0].length-1;j++){
                if(board[i][j]=='O')
                    SearchAndFlip(board,i,j,'X');
            }
        }
        for(int[] pair:edge){
            board[pair[0]][pair[1]] = 'O';
        }
    }
}