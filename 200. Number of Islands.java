/*
DFS，从为1的点四处扩展，扩展到的设为0
在主函数设一总循环保证所有位置都遍历到
注意dfs时的条件限定，当前位置一定要是1
*/
class Solution {
    public void searchAndSetZero(char[][] grid, int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1'){
            grid[i][j] = '0';
            searchAndSetZero(grid,i+1,j);
            searchAndSetZero(grid,i-1,j);
            searchAndSetZero(grid,i,j+1);
            searchAndSetZero(grid,i,j-1);
        }
        else{
            return;
        }
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    searchAndSetZero(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}