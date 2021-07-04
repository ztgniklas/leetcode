class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<S.length();i++){
            if(stack.isEmpty() || stack.getLast()!=S.charAt(i)){
                stack.add(S.charAt(i));
            }
            else{
                stack.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
    
}

/*
消消乐，用栈解决，没什么可说的
StringBuilder的append的参数可以是任何类型
*/