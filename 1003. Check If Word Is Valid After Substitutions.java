/*
用栈，保证栈顶是abc才是valid
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.size() < 2) {
                    return false;
                }
                if (stack.pop() != 'b') {
                    return false;
                }
                if (stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
        
    }
}