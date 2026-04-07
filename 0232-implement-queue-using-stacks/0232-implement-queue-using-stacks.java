class MyQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MyQueue() {
        stackA = new Stack<>();
        stackB =new Stack<>();
    }
    
    public void push(int x) {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        stackA.push(x);
        while(!stackB.isEmpty()) stackA.push(stackB.pop());
    }
    
    public int pop() {
       return stackA.pop();
    }
    
    public int peek() {
      return  stackA.peek();
    }
    
    public boolean empty() {
        return stackA.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */