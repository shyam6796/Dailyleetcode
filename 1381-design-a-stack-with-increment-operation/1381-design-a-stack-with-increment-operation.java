class CustomStack {
    Stack<Integer> stack;
    int cap;
    public CustomStack(int maxSize) {
        stack=new Stack<>();
        cap = maxSize;
    }
    
    public void push(int x) {
        if(cap==stack.size()) return;
        stack.push(x);
    }
    
    public int pop() {
        if(stack.isEmpty())return -1;
        return stack.pop();
    }
    
    public void increment(int k, int val) {

      Stack<Integer> reverseStack = new Stack<>();
        while(!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        while(!reverseStack.isEmpty()) {
            if(k != 0) {
                stack.push(reverseStack.pop() + val);
                k--;
            } else {
                stack.push(reverseStack.pop());
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */