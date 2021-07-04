/**
 * 无向无权重图最短路径，考虑BFS
 * 把所有对新square的判断放到poll之后判断，不然会因为判断顺序导致错误结果
 */
class Solution {
    public int snakesAndLadders(int[][] board) {
        int row = board.length, col = board[0].length, numOfMove = 0;
        if (row == 1) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[row * col + 1];
        Arrays.fill(visited, false);
        queue.offer(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curS = queue.poll();
                if (visited[curS]) {
                    continue;
                }
                visited[curS] = true;
                if (curS == row * col) {
                    return numOfMove;
                }
                for (int j = 1; j <= 6; j++) {
                    int nextS = curS + j;
                    if (nextS > row * col) {
                        continue;
                    }
                    int[] nextLoc = square2Loc(nextS, row, col);
                    if (board[nextLoc[0]][nextLoc[1]] != -1) {
                        // need take s/l
                        queue.offer(board[nextLoc[0]][nextLoc[1]]);
                    } else {
                        queue.offer(nextS);
                    }
                }
                
            }
            numOfMove++;
        }
        return -1;
    }
    
    private int[] square2Loc(int s, int row, int col) {
        int x = row - (s - 1) / row - 1;
        int y = 0;
        if (((s - 1) / row) % 2 == 0) {
            // left to right
            y = (s - 1) % row;
        } else {
            y = row - ((s - 1) % row) - 1;
        }
        return new int[] {x, y};
        
    }
}