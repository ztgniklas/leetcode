/*
和54题类似，碰壁或前方已经填充数字则换方向
*/
class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 1)
            return new int[][]{};
        int[] directionX = {0,1,0,-1};
        int[] directionY = {1,0,-1,0};
        int[][] matrix = new int[n][n];
        int direct = 0;
        int row = 0, col = -1;
        
        for (int[] arr: matrix)
            Arrays.fill(arr, 0);
        //1 -> n^2
        int i = 1;
        while (i <= n * n) {
            if (row + directionX[direct] >= 0 && row + directionX[direct] < n && col + directionY[direct] >= 0 && col + directionY[direct] < n && matrix[row + directionX[direct]][col + directionY[direct]] == 0) {
                row += directionX[direct];
                col += directionY[direct];
                matrix[row][col] = i;
                i++;
            }
            else {
                direct = (direct + 1) % 4;
            }
        }
    
        return matrix;
    }
}