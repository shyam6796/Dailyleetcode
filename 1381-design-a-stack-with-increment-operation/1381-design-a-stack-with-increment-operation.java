class CustomStack {
    int cap;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        stack =new Stack<>();
        cap =maxSize;
    }
    
    public void push(int x) {
        if(stack.size() ==cap)return;
            stack.push(x);
        
    }
    
    public int pop() {
        if(stack.isEmpty())return -1;
        return stack.pop();
    }
    
    public void increment(int k, int val) {
        Stack<Integer> buffer =new Stack<>();
        while(!stack.isEmpty() ){
            buffer.push(stack.pop());
        }
        while(!buffer.isEmpty()){
            if(k>0){
                stack.push(val+buffer.pop());
                k--;
            }else{
                stack.push(buffer.pop());
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