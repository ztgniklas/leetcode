class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] rst = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rst[i][j] = smoothACell(i, j, img);
            }
        }
        return rst;
    }
    
    private int smoothACell(int row, int col, int[][] img) {
        int m = img.length, n = img[0].length, validCells = 1;
        double total = img[row][col];
        int[] dirX = {0, 0, 1, -1, 1, 1, -1, -1}, dirY = {1, -1, 0, 0, 1, -1, -1, 1};
        for (int i = 0; i < 8; i++) {
            int curRow = row + dirX[i], curCol = col + dirY[i];
            if (isValidCell(curRow, curCol, m, n)) {
                total += img[curRow][curCol];
                validCells++;
            }
            
        }
        
        return (int) Math.floor(total / validCells);
    }
    
    private boolean isValidCell(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
    
}