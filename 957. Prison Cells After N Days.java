class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> lhs = new LinkedHashSet<>();
        String rst = "";
        
        for (int i = 0; i < n; i++) {
            int[] tmp = changeOnce(cells);
            if (lhs.contains(int2String(tmp))) {
                break;
            }
            lhs.add(int2String(tmp));
            cells = Arrays.copyOf(tmp, 8);
        }
        // there is a cycle
        if (n > lhs.size()) {
            int res = n % lhs.size();
            Iterator i = lhs.iterator();
            int idx = 1;
            while (i.hasNext()) {
                rst = (String) i.next();
                if (idx == res) {
                    break;
                }
                idx++;
            }
        } else {
            Iterator i = lhs.iterator();
            while (i.hasNext()) {
                rst = (String) i.next();
            }
        }
        int[] endState = new int[8];
        for (int i = 0; i < 8; i++) {
            endState[i] = (int) (rst.charAt(i) - '0');
        }
        return endState;
    }
    
    private int[] changeOnce(int[] s) {
        int[] nextChars = new int[8];
        for (int i = 1; i < 7; i++) {
            nextChars[i] = s[i - 1] ^ s[i + 1] ^ 1;
        }
        nextChars[0] = 0;
        nextChars[7] = 0;
        return nextChars;
    }
    
    private String int2String(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}