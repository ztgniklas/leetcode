/*
碰到墙壁或前方数字已经被访问过了，就按照右下左上顺序换方向，连续换三次方向则视为走到尽头
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return rst;
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        
        int direct = 0;
        int row = 0, col = 0;
        int flag = 4;
        while (true) {
            if (matrix[row][col] != Integer.MIN_VALUE)
                rst.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            if (row + directionX[direct] >= 0 && row + directionX[direct] < matrix.length && col + directionY[direct] >= 0 && col + directionY[direct] < matrix[0].length && matrix[row + directionX[direct]][col + directionY[direct]] != Integer.MIN_VALUE) {
                row += directionX[direct];
                col += directionY[direct];
                flag = 4;
            }
            else {
                flag--;
                while (true) {
                	direct = (direct + 1) % 4;
                	if (row + directionX[direct] >= 0 && row + directionX[direct] < matrix.length && col + directionY[direct] >= 0 && col + directionY[direct] < matrix[0].length && matrix[row + directionX[direct]][col + directionY[direct]] != Integer.MIN_VALUE) {
                        
            	  	flag = 4;
                	row += directionX[direct];
                	col += directionY[direct];
                        break;
                    }
                    flag--;
                    if (flag == 0)
                        return rst;
                }
            }
            if (flag == 0)
                break;
        }
        return rst;
    }
}