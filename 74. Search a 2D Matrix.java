/*
把各个行首尾接在一起实际上就是一个递增数组
所以用二分法，具体察看mid对应值的时候再用mid/col和mid%col定位在矩阵中的位置
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int curRow = mid / col;
            int curCol = mid % col;
            if (matrix[curRow][curCol] == target)
                return true;
            else if (matrix[curRow][curCol] > target)
                end = mid;
            else if (matrix[curRow][curCol] < target)
                start = mid;
        }
        
        if (matrix[start / col][start % col] == target)
            return true;
        if (matrix[end / col][end % col] == target)
            return true;
        
        return false;
    }
}