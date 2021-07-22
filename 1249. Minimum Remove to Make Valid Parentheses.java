/**
 * 使用栈，'('进栈，遇到')'出栈。如果栈是空的，说明此时')'多余，记录下其索引
 * 如果遍历完栈不空，说明前面'('多余，这就要在之前'('入栈时记录其索引，方便此时
 * 追踪。最后把所有记录的索引下的括号全部删除即可
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackI = new Stack<>();
        Set<Integer> idx2rm = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            if (curC == '(') {
                stack.push(curC);
                stackI.push(i);
            } else if (curC == ')') {
                if (stack.isEmpty()) {
                    idx2rm.add(i);
                } else {
                    stack.pop();
                    stackI.pop();
                }
            }
        }
        while (!stackI.isEmpty()) {
            idx2rm.add(stackI.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!idx2rm.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}