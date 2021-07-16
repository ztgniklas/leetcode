/**
 * dfs，要分别记录当前构成字符串中左右括号的数量。一旦
 * left < right，之后无论有什么，一定invalid了，可以剪枝
 * 其他情况全部同时考虑加入或不加入当前字符（字母一定加）
 */
class Solution {
    Set<String> rst;
    int maxLen;
    public List<String> removeInvalidParentheses(String s) {
        rst = new HashSet<>();
        maxLen = Integer.MIN_VALUE;
        dfs(s, new StringBuilder(), 0, 0, 0);
        return new ArrayList<>(rst);
    }
    
    private void dfs(String s, StringBuilder sb, int leftCnt, int rightCnt, int curIdx) {
        if (curIdx == s.length()) {
            // is valid
            if (leftCnt == rightCnt) {
                if (sb.length() > maxLen) {
                    // new maximum length, give up previous results
                    maxLen = sb.length();
                    rst.clear();
                    rst.add(sb.toString());
                } else if (sb.length() == maxLen) {
                    rst.add(sb.toString());
                }
            }
            return;
        }
        if (s.charAt(curIdx) == '(') {
            sb.append("(");
            dfs(s, new StringBuilder(sb), leftCnt + 1, rightCnt, curIdx + 1);
            sb.deleteCharAt(sb.length() - 1);
            dfs(s, new StringBuilder(sb), leftCnt, rightCnt, curIdx + 1);
        } else if (s.charAt(curIdx) == ')') {
            // too many ')'
            if (leftCnt < rightCnt + 1) {
                
            } else {
                dfs(s, new StringBuilder(sb.append(")")), leftCnt, rightCnt + 1, curIdx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            dfs(s, new StringBuilder(sb), leftCnt, rightCnt, curIdx + 1);
            
        } else {
            sb.append(s.charAt(curIdx));
            dfs(s, new StringBuilder(sb), leftCnt, rightCnt, curIdx + 1);
        }
    }
}