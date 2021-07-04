class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                path[i][j] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                path[i][j] = path[i-1][j]+path[i][j-1];
            }
        }
        return path[n-1][m-1];
    }
}

/*
DP思想，uniquePaths(m,n)=uniquePaths(m-1,n)+uniquePaths(m,n-1)
但是直接写成递归会超时。可以维护一个二维数组path[n][m]，初始值全为1
其中path[i][j]表示从path[0][0]到path[i][j]的路径数
可以从path[1][1]开始，因为第一行或第一列肯定是1
*/