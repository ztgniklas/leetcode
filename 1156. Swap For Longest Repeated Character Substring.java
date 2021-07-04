class Solution {
    public int maxRepOpt1(String text) {
        char lastC = '0';
        int repeatedTimes = 0, maxRep = 1;
        List<KV> repSeries = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
            if (text.charAt(i) != lastC) {
                repSeries.add(new KV(lastC, repeatedTimes));
                lastC = text.charAt(i);
                repeatedTimes = 1;
            } else {
                repeatedTimes++;
            }
        }
        repSeries.add(new KV(lastC, repeatedTimes));
        // remove the first KV with the key '0'
        repSeries.remove(0);
        // now inside repSeries is like [('a', 2), ('b', 3), ('a', 1)]
        // and map stores the frequency of each character
        for (int i = 1; i < repSeries.size() - 1; i++) {
            // "aaabaa" we swap b and a
            if (repSeries.get(i - 1).key == repSeries.get(i + 1).key && repSeries.get(i).val == 1) {
                int curMax = repSeries.get(i - 1).val + repSeries.get(i + 1).val;
                // "aaabaac...aaa"
                if (map.get(repSeries.get(i - 1).key) > repSeries.get(i - 1).val + repSeries.get(i + 1).val) {
                    curMax++;
                }
                maxRep = Math.max(maxRep, curMax);
            } else {
                // look at max repeated times of left and right side series
                if (map.get(repSeries.get(i - 1).key) > repSeries.get(i - 1).val) {
                    maxRep = Math.max(maxRep, repSeries.get(i - 1).val + 1);
                }
                if (map.get(repSeries.get(i + 1).key) > repSeries.get(i + 1).val) {
                    maxRep = Math.max(maxRep, repSeries.get(i + 1).val + 1);
                }
            }
        }
        // case like "aaaa"
        if (repSeries.size() == 1) {
            maxRep = repSeries.get(0).val;
        }
        // case like "aaabb"
        if (repSeries.size() == 2) {
            maxRep = Math.max(repSeries.get(0).val, repSeries.get(1).val);
        }
        return maxRep;
    }
    
    class KV {
        char key;
        int val;
        
        public KV() {
            
        }
        
        public KV(char key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}