/*
在存放数据的栈之外再维护一个栈minStack，专门用于存放数据栈状态下的最小值
即每push一个值时，把该值与minStack栈顶，也就是之前的最小值做对比，决定应存放哪个值
*/
class MinStack {
	private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else
            minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
    	stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}