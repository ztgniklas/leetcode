class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letLogs = new ArrayList<>(), digLogs = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compare(a, b));
        for (String log : logs) {
            String[] words = log.split(" ");
            if (Character.isDigit(words[1].charAt(0))) {
                digLogs.add(log);
                continue;
            }
            pq.offer(log);
        }
        while (!pq.isEmpty()) {
            letLogs.add(pq.poll());
        }
        letLogs.addAll(digLogs);
        return letLogs.toArray(new String[0]);
    }
    
    private int compare(String a, String b) {
        String[] wordsA = a.split(" "), wordsB = b.split(" ");
        String idA = wordsA[0], idB = wordsB[0];
        for (int i = 1; i < Math.min(wordsA.length, wordsB.length); i++) {
            if (compareLexi(wordsA[i], wordsB[i]) != 0) {
                return compareLexi(wordsA[i], wordsB[i]);
            }
        }
        if (wordsA.length != wordsB.length) {
            return wordsA.length < wordsB.length ? -1 : 1;
        }
        return compareLexi(idA, idB);
        
    }
    
    private int compareLexi(String cttA, String cttB) {
        for (int i = 0; i < Math.min(cttA.length(), cttB.length()); i++) {
            if (cttA.charAt(i) == cttB.charAt(i)) {
                continue;
            }
            return cttA.charAt(i) < cttB.charAt(i) ? -1 : 1;
        }
        if (cttA.length() != cttB.length()) {
            return cttA.length() < cttB.length() ? -1 : 1;
        }
        return 0;
    }
    
}