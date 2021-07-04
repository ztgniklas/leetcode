/*
贪心法，先尝试取当前可取的最大的数，限制条件就是相同label的数量不能超过use_limit
一旦不满足限制条件就往后找即可，通过维护一个map保存特定label已使用的次数
*/
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int numOfSet = values.length;
        Item[] items = new Item[numOfSet];
        for (int i = 0; i < numOfSet; i++) {
            Item item = new Item(values[i], labels[i]);
            items[i] = item;
        }
        // sort items by descendant order
        Arrays.sort(items, (a, b) -> b.val - a.val);
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numOfSet && num_wanted > 0; i++) {
            int val = items[i].val;
            int label = items[i].label;
            if (map.getOrDefault(label, 0) < use_limit) {
                map.put(label, map.getOrDefault(label, 0) + 1);
                sum += val;
                num_wanted--;
            }
        }
        return sum;
    }
    
    class Item {
        public int val, label;
        public Item(int val, int label) {
            this.val = val;
            this.label = label;
        }
        
        public boolean equals(Item other) {
            return this.val == other.val;
        }
    }
}