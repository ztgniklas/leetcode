/**
 * 看到奇奇怪怪的合并，可以考虑并查集
 * 我们通过遍历每个email，建立所有email的关系网络，这里要给每个email绑定一个
 * id，方便并查集操作，绑定所属用户名，方便最后一步加入名字。之后对每个email
 * 查找其root，root相同的放到一个数组里。这里也可以维护一个root id为key的map
 * 方便查找相应数组
 */
class Solution {
    int[] father;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        father = new int[10001];
        Map<String, Integer> email2Id = new HashMap<>();
        Map<String, String> email2Name = new HashMap<>();
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        int id = 0;
        for (List<String> acct : accounts) {
            String name = acct.get(0);
            for (int i = 1; i < acct.size(); i++) {
                email2Name.put(acct.get(i), name);
                if (!email2Id.containsKey(acct.get(i))) {
                    email2Id.put(acct.get(i), id++);
                }
                union(email2Id.get(acct.get(1)), email2Id.get(acct.get(i)));
            }
        }
        
        Map<Integer, List<String>> rst = new HashMap<>();
        for (String email : email2Id.keySet()) {
            int rootId = find(email2Id.get(email));
            if (!rst.containsKey(rootId)) {
                List<String> es = new ArrayList<>(){{add(email);}};
                rst.put(rootId, es);
            } else {
                List<String> es = rst.get(rootId);
                es.add(email);
                rst.put(rootId, es);
            }
        }
        for (List<String> es : rst.values()) {
            Collections.sort(es);
            es.add(0, email2Name.get(es.get(0)));
        }
        return new ArrayList<>(rst.values());
    }
    
    private int find(int e) {
        int root = father[e];
        if (root == e) {
            return root;
        }
        return father[e] = find(father[e]);
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        father[rootA] = rootB;
    }
    
}