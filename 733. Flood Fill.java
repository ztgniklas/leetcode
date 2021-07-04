/**
 * 实际上是个递归（dfs）题，用BFS时间复杂度高了
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int m = image.length, n = image[0].length;
        int[] dirX = {1, -1, 0, 0}, dirY = {0, 0, 1, -1};
        Set<Integer> hs = new HashSet<>();
        queue.offer(new int[] {sr, sc});
        int color = image[sr][sc];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curLoc = queue.poll();
                if (image[curLoc[0]][curLoc[1]] != color) {
                    continue;
                }
                image[curLoc[0]][curLoc[1]] = newColor;
                if (hs.contains(curLoc[0] * n + curLoc[1])) {
                    continue;
                }
                hs.add(curLoc[0] * n + curLoc[1]);
                for (int j = 0; j < 4; j++) {
                    int nextX = curLoc[0] + dirX[j];
                    int nextY = curLoc[1] + dirY[j];
                    if (nextX >= 0 && nextX < m && nextY >=0 && nextY < n) {
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }
        return image;
    }
}