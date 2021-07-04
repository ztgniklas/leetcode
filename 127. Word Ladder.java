/*
一步变换就是换一个字母。可以把一个单词想象为一个节点，相差一个字母的单词相邻，边长为1，这样构成了一个简单无向图。求最短变换次数，实际上就是求从beginWord到endWord的最短路径。
由此首先可以想到BFS，类似层次遍历的方式，记录遍历层数即为ladderLength；
同时还可以维护一个数组记录单词有没有被访问过，防止单词被重复加入队列。
*/
class Solution {
    public int distance(String word1, String word2) {
        int rst = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                rst++;
        }
        return rst;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
            return 0;
        
        boolean[] visited = new boolean[wordList.size()];
        Arrays.fill(visited, false);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && distance(curWord, wordList.get(j)) == 1) {
                        queue.offer(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }
            level++;
            if (queue.contains(endWord))
                return level;
        }
        return 0;
    }
}