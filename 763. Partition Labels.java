/**
 * 对于这个问题，首先应该考虑的不是最多能分割成几部分，而是能按照规则分割几部分
 * 对于第0个字母，其所在的分割部分至少是从0到该字母最后出现的索引
 * 比如对于字符串"abcbabaefabjji"，只考虑a的话第一部分至少分成"abcbabaefa"才符合规则
 * 然后对于这一划分中的每一个字母，也要找到其最后出现的索引，最后取最大的索引数，就是
 * 划分的边界。而因为题意是最多能分割几部分，我们的方法是追求每部分“至少”，所以是符合题意的。
 * 比如例子中，b最后出现的索引最大，所以最终的分割应该是取"abcbabaefab"。
 * 对于之后的字符串，按照以上方法递归处理即可。
 * 实际编写中可以引入集合，跳过之前已经访问过的重复字母，减少执行时间。
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> rst = new ArrayList<>();
        helper(rst, s);
        return rst;
    }
    
    private void helper(List<Integer> rst, String s) {
        if (s == null || s.length() <= 0) {
            return;
        }
        char first = s.charAt(0);
        int end = 0; // included
        // find the last occurence index of first char
        for (int i = s.length() - 1; i > 0; i--) {
            if (first == s.charAt(i)) {
                end = i;
                break;
            }
        }
        // the division is like "a" or "aa"
        if (end <= 1) {
            rst.add(end - 0 + 1);
            helper(rst, s.substring(end + 1));
            return;
        }
        // no legal partition should be done
        if (end == s.length() - 1) {
            rst.add(end - 0 + 1);
            return;
        }
        Set<Character> visited = new HashSet<>();
        visited.add(first);
        for (int i = 1; i < end; i++) {
            char curC = s.charAt(i);
            if (visited.contains(curC)) {
                continue;
            }
            visited.add(curC);
            int newEnd = end;
            // find the last occurence index of curC
            for (int j = s.length() - 1; j > end; j--) {
                if (curC == s.charAt(j)) {
                    newEnd = j;
                    break;
                }
            }
            // update the partition range
            end = newEnd;
        }
        rst.add(end - 0 + 1);
        helper(rst, s.substring(end + 1));
    }
}