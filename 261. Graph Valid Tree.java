/*
一个图是树，应该满足两个条件：
1.n个点n-1条边
2.所有点联通

对于第二个条件，使用BFS遍历所有节点。维护一个set记录所有访问过的节点，每次往队列里放当前节点的邻居都要检验邻居是否已被访问，防止死循环。
最后对比set中的节点个数是否等于n即可（等于说明从初始节点可以到达任一结点，说明图联通）
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1)
            return true;
        if (edges.length != n - 1)
            return false;
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0],new HashSet<>());
                graph.get(edge[0]).add(edge[1]);
            }
            else {
                graph.get(edge[0]).add(edge[1]);
            }
            
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1],new HashSet<>());
                graph.get(edge[1]).add(edge[0]);
            }
            else {
                graph.get(edge[1]).add(edge[0]);
            }
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            
            for (Integer neighbor: graph.get(curNode)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
                
            }
        }
        
        if (visited.size() == n) 
            return true;
        
        return false;
        
    }
}