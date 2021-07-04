/**
 * 这个排序虽然看起来很复杂，但依然还可以通过重写Arrays.sort的Comparator实现
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i * C + j][0] = i;
                matrix[i * C + j][1] = j;
            }
        }
        Arrays.sort(matrix, (a, b) -> {
            return Math.abs(a[0] - r0) + Math.abs(a[1] - c0) - Math.abs(b[0] - r0) - Math.abs(b[1] - c0);
        });
        return matrix;
    }
}