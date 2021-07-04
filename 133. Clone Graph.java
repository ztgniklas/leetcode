/*
BFS
1. node -> nodes
2. copy nodes
3. copy edges
注意要deep copy而不能只是reference，所以直接deep copy neighbors是不行的，要通过map对新老结点的映射关系，确定edges
*/
class Solution {
    public Set<Node> getNodes(Node node) {
        Set<Node> nodes = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        nodes.add(node);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node n: curNode.neighbors) {
                if (!nodes.contains(n)) {
                    queue.offer(n);
                    nodes.add(n);
                }
            }
        }
        return nodes;
    }
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        //1. node -> nodes
        Set<Node> nodes = getNodes(node);
        //2. copy nodes
        Map<Node,Node> hm = new HashMap<>();
        for (Node n: nodes) {
            hm.put(n, new Node(n.val));
        }
        //3. copy edges
        for (Node n: nodes) {
            for (Node neighbor: n.neighbors) {
                hm.get(n).neighbors.add(hm.get(neighbor));
            }
        }
        return hm.get(node);
    }
}