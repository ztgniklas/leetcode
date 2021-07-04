/**
 * 维护一个大根堆，从高位向低位搜索，每一位之后的所有数如果最大值比其大，则交换
 */
class Solution {
    public int maximumSwap(int num) {
        // 96267 97266
        int digits = 0;
        List<Integer> numList = new ArrayList<>();
        // val loc
        PriorityQueue<VL> pq = new PriorityQueue<>((a,b) -> b.val == a.val ? a.loc - b.loc : b.val - a.val);
        while (num > 0) {
            int tmp = num % 10;
            numList.add(tmp);
            pq.offer(new VL(tmp, numList.size() - 1));
            num /= 10;
        }
        digits = numList.size();
        for (int i = digits - 1; i >= 1; i--) {
            pq.remove(new VL(numList.get(i), i));
            VL maxDigit = pq.peek();
            int curDigit = numList.get(i);
            if (curDigit < maxDigit.val) {
                numList.set(i, maxDigit.val);
                numList.set(maxDigit.loc, curDigit);
                break;
            }
        }
        int rst = 0;
        for (int i = digits - 1; i >= 0; i--) {
            rst *= 10;
            rst += numList.get(i);
        }
        return rst;
    }

    class VL {
        public int val, loc;
        public VL() {

        }

        public VL(int val, int loc) {
            this.val = val;
            this.loc = loc;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof VL)) {
                return false;
            }
            VL that = (VL) o;
            return this.loc == that.loc && this.val == that.val;
        }
    }
}