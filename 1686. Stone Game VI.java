// The optimal strategy is choose the i-th stone among all the available stones
// to which the sum of the Alice's and Bob's values is the largest. So we sort 
// the stones by the sum of values, and each turn we pick the one with largest sum.
// the poll() requires O(logN), thus the time complexity is O(NlogN).
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int alice = 0, bob = 0;
        boolean aliceTurn = true;
        for (int i = 0; i < aliceValues.length; i++) {
            int[] pair = new int[]{i, aliceValues[i] + bobValues[i]};
            pq.add(pair);
        }
        
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            if (aliceTurn) {
               alice += aliceValues[pair[0]] ;
            } else {
                bob += bobValues[pair[0]];
            }
            aliceTurn = !aliceTurn;
        }
        if (alice > bob) {
            return 1;
        }
        if (alice == bob) {
            return 0;
        }
        return -1;
    }
}