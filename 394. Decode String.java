/*
这种括号问题，一般想到用栈做，因为需要利用栈能够暂时保存有用信息这一特性，来记录之前的字符串和定位[]。
本题利用了翻转栈的操作，将输出的一段字符串顺序纠正过来，再放到栈里
另外，要注意匹配大于一位数的数字
*/
class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int number = 0;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c))
                number = number * 10 + Integer.valueOf(c - '0');
            else if (c == '[') {
                stack.push(number);
                number = 0;
            }
            else if (c == ']') {
                String revStr = revPop(stack);
                Integer cnt = (Integer) stack.pop();
                for (int i = 0; i < cnt; i++)
                    stack.push(revStr);
            }
            else
                stack.push(String.valueOf(c));
        }
        return revPop(stack);
    }
    
    public String revPop(Stack<Object> stack) {
        Stack<String> revStack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            revStack.push((String) stack.pop());
        }
        while (!revStack.isEmpty()) {
            sb.append(revStack.pop());
        }
        return sb.toString();
    }
}