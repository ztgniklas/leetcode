/**
 * 纯数学计算
 */
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) {
            return new ArrayList<>(){{add(1);}};
        }
        int level = 0, sum = 0, num = 1;
        while (sum < label) {
            sum += num;
            num *= 2;
            level++;
        }
        
        // level: level of the label
        // num: num of current level
        num /= 2;
        int numOfLastLevel = num / 2;
        int parentLabel = sum - num - numOfLastLevel + (numOfLastLevel - (int) Math.ceil((label - (sum - num)) / 2f) + 1);
        List<Integer> rst = pathInZigZagTree(parentLabel);
        rst.add(label);
        return rst;
    }
}