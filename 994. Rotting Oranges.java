/*
相当于验证连通性，考虑BFS
注意全0的corner case
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        int minutes = -1;
        int zeroNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 0) {
                    zeroNum++;
                }
            }
        }
        if (zeroNum == m * n) {
            return 0;
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                int x = loc[0], y = loc[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + directionX[j], nextY = y + directionY[j];
                    if (nextX >= 0 && nextX < m &&
                        nextY >= 0 && nextY < n &&
                        grid[nextX][nextY] == 1) {
                        queue.add(new int[]{nextX,nextY});
                        grid[nextX][nextY] = 2;
                    }
                }
            }
            minutes++;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return minutes;
        
        
    }
}