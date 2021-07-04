/**
 * BFS
 * 难点在于如何判断下一步该选哪种颜色和如何维护visited集合
 * 分别创建红蓝edge的邻接表。向queue中放入的不只有node还有到达该node的edge的颜色
 * 这样就可以确定下一个node应该走什么颜色，从而从特定的邻接表中查找
 * 同样，visited中也不能只记录node，因为从不同颜色edge到达的同一个node并不能算作重复
 * 否则可能出现从红色到达过node1，但有的node需要通过蓝色到达node1再通过红色到达之，
 * 如果只记录node1而不记录颜色，会认为访问过node1导致不会再查找其红色的邻接表，
 * 从而造成一些node明明有路径却找不到的错误
 */
class Solution {
    public static final int RED = 1, BLUE = 2;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Queue<int[]> queue = new LinkedList<>();
        int[] rst = new int[n];
        Arrays.fill(rst, -1);
        Set<String> visited = new HashSet<>();
        Map<Integer, Set<Integer>> map4Red = new HashMap<>(), map4Blue = new HashMap<>();
        // create adjacent list for red edges
        for (int[] edge : red_edges) {
            Set<Integer> hs = map4Red.getOrDefault(edge[0], new HashSet<>());
            hs.add(edge[1]);
            map4Red.put(edge[0], hs);
        }
        
        // for blue edges
        for (int[] edge : blue_edges) {
            Set<Integer> hs = map4Blue.getOrDefault(edge[0], new HashSet<>());
            hs.add(edge[1]);
            map4Blue.put(edge[0], hs);
        }
        
        int path = 0;
        // [node, colorToThisNode]
        queue.offer(new int[]{0, RED});
        queue.offer(new int[]{0, BLUE});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] nAC = queue.poll();
                int curNode = nAC[0];
                int lastColor = nAC[1];
                StringBuffer sb = new StringBuffer();
                sb.append("n").append(curNode).append("C").append(lastColor);
                String visitedStr = sb.toString();
                if (visited.contains(visitedStr)) {
                    continue;
                }
                visited.add(visitedStr);
                if (rst[curNode] == -1) {
                    rst[curNode] = path;
                }
                if (lastColor == RED) {
                    Set<Integer> hs = map4Blue.getOrDefault(curNode, new HashSet<>());
                    for (int nextNode : hs) {
                        queue.offer(new int[]{nextNode, BLUE});
                    }
                } else {
                    Set<Integer> hs = map4Red.getOrDefault(curNode, new HashSet<>());
                    for (int nextNode : hs) {
                        queue.offer(new int[]{nextNode, RED});
                    }
                }
            }
            path++;
        }
        return rst;
        
    }
}