/**
 * 维护两个map，一个存储出现在arr2的元素及其在arr1中出现的次数
 * 另一个存储没有出现在arr2的元素及其在arr1中出现的次数
 * 按照arr2中的顺序填入第一个map的元素
 * 最后对第二个map按照key排序，再填入
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> eleIn2 = new HashMap<>(), eleNotIn2 = new HashMap<>();
        for (int ele : arr1) {
            if (contains(arr2, ele)) {
                eleIn2.put(ele, eleIn2.getOrDefault(ele, 0) + 1);
            } else {
                eleNotIn2.put(ele, eleNotIn2.getOrDefault(ele, 0) + 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.<Integer, Integer> comparingByKey());
        for (Map.Entry<Integer, Integer> entry : eleNotIn2.entrySet()) {
            pq.offer(entry);
        }
        
        int[] rst = new int[arr1.length];
        int idx = 0;
        for (int ele : arr2) {
            int freq = eleIn2.get(ele);
            while (freq > 0) {
                rst[idx++] = ele;
                freq--;
            }
        }
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int freq = entry.getValue();
            while (freq > 0) {
                rst[idx++] = entry.getKey();
                freq--;
            }
        }
        return rst;
        
    }
    
    private boolean contains(int[] arr, int ele) {
        for (int e : arr) {
            if (e == ele) {
                return true;
            }
        }
        return false;
    }
}