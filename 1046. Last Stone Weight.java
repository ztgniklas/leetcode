/*
一看到取最大值就考虑用heap，每次取两个最大值，作差后再加入heap
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            pq.add(stone);
        }
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            int result = first - second;
            if (result > 0) {
                pq.add(result);
            }
            
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}

/*
模拟法，每次对数组排序，指针指向最大值，同时设置第二个指针指向不是0的最小值（若有）
保证取到的值valid
*/
/*class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int pt = stones.length - 1;
        int baseIdx = 0;
        Arrays.sort(stones);
        while (pt > baseIdx) {
            stones[pt - 1] = stones[pt] - stones[pt - 1];
            if (stones[pt - 1] == 0) {
                baseIdx++;
            }
            pt--;
            Arrays.sort(stones);
        }
        return stones[pt];
    }
}*/