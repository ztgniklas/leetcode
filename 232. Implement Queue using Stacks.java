/*
翻转栈的应用。使用两个栈，一个用于进数据，一个用于出数据，这样后者就会把前者的放入顺序作为出栈顺序，即实现了队列的功能
例如：一个队列 头 |1234| 尾， 其出队顺序是1、2、3、4
使用两个栈，第一个栈 底 |1234| 顶
第二个栈接收第一个栈的弹出，变成 底 |4321| 顶
这样，第二个栈的弹出顺序就是1、2、3、4了，与队列一致
*/
class MyQueue {
	private Stack<Integer> stack;
    private Stack<Integer> revStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        revStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (revStack.isEmpty()) {
            while (!stack.isEmpty()) {
                revStack.push(stack.pop());
            }
        }
        return revStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (revStack.isEmpty()) {
            while (!stack.isEmpty()) {
                revStack.push(stack.pop());
            }
        }
        return revStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && revStack.isEmpty();
    }
}