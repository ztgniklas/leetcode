/**
 * 判断存在用hashtable即可保证O(1)，同时保存元素的索引
 * remove方法实现O(1)的时间复杂度比较困难，利用arraylist删除最后一个元素
 * 时间复杂度为O(1)的特点（因为没有元素前移操作），将待删除元素与末尾元素交换
 * 再删除之即可。其他情况，因为是arraylist，取数操作都是O(1)的
 */
class RandomizedSet {
    Map<Integer, Integer> val2Idx;
    List<Integer> vals;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        val2Idx = new HashMap<>();
        vals = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (val2Idx.containsKey(val)) {
            return false;
        }
        val2Idx.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!val2Idx.containsKey(val)) {
            return false;
        }
        int delIdx = val2Idx.get(val), lastIdx = vals.size() - 1, lastVal = vals.get(lastIdx);
        if (delIdx != lastIdx) {
            // swap
            Collections.swap(vals, delIdx, lastIdx);
            val2Idx.put(lastVal, delIdx);
        }
        vals.remove(lastIdx);
        val2Idx.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int) (Math.random() * vals.size());
        return vals.get(idx);
    }
}