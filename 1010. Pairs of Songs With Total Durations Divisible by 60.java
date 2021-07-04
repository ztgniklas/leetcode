/*
碰到除法这种数学问题，考虑取余的可能
显然，(i + j) % 60 == (i % 60 + j % 60) % 60
因此对数组的值模60，不影响最终的结果，并且可以将所有值控制在[0,59]区间，由此转化为了two sum问题
使用map即可在O(n)时间复杂度解决问题。注意本身整除60和(i+j)%60==0 && i==j的情况(C{n}^2)
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < time.length; i++) {
            int ele = time[i] % 60;
            if (map.containsKey(ele)) {
                map.put(ele, map.get(ele) + 1);
            } else {
                map.put(ele, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getKey() == 0) {
                num += entry.getValue() * (entry.getValue() - 1);
                continue;
            }
            int rest = 60 - entry.getKey();
            if (rest == entry.getKey()) {
                num += entry.getValue() * (entry.getValue() - 1);
            } else if (map.containsKey(rest)) {
                num += entry.getValue() * map.get(rest);
            }
        }
        return num / 2;
    }
}