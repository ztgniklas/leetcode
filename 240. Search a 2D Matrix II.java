/*
从左下到右上
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1, y = 0;
        
        while (x >= 0 && y <= col -1) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target) {
                x--;
            }
            else if (matrix[x][y] < target) {
                y++;
            }
        }
        
        return false;
    }
}