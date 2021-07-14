/**
 * 统计相同的age
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }
        for (int i : map.keySet()) {
            for (int j : map.keySet()) {
                if (i != j) {
                    if (makeReq(i, j)) {
                        num += map.get(i) * map.get(j);
                    }
                } else {
                    if (makeReq(i, j)) {
                        num += map.get(i) * (map.get(i) - 1);
                    }
                }
            }
        }
        return num;
    }
    
    private boolean makeReq(int a, int b) {
        return !(b <= 0.5f * a + 7 || b > a || b > 100 && a < 100);
    }
}