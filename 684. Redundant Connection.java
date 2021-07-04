/**
 * 使用并查集，第一次出现union操作两个节点拥有相同root，就说明
 * 当前edge是形成闭环的，应删除之
 */
class Solution {
    int[] parent = new int[1001];
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
    
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
        return true;
    }
}