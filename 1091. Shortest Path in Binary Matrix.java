/*
最短路径考虑BFS，注意寻路出现的无限循环导致超时的问题
要维护一个二维数组记录搜寻过程中走过的位置，如果之前走过，一定不用再考虑了，因为必然不会再是最短路径
*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1) {
            return -1;
        }
        int[] directionX = {1,1,1,0,0,-1,-1,-1};
        int[] directionY = {-1,0,1,-1,1,-1,0,1};
        int n = grid.length, path = 0;
        boolean[][] visited = new boolean[n][n];
        
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int sizeOfCurQ = queue.size();
            path++;
            for (int i = 0; i < sizeOfCurQ; i++) {
                int[] loc = queue.poll();
                int x = loc[0], y = loc[1];
                if (x == n - 1 && y == n - 1) {
                    return path;
                }
                for (int j = 0; j < 8; j++) {
                    int nextX = x + directionX[j];
                    int nextY = y + directionY[j];
                    if (isValidLocation(nextX, nextY, n) &&
                       grid[nextX][nextY] == 0 &&
                       !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
                
            }
        }
        return -1;
    }
    
    private boolean isValidLocation(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}