class MyStack {
    Queue<Integer> queueA;
    Queue<Integer> queueB;
    
    public MyStack() {

        queueA =new LinkedList<>();
        
    }
    
    public void push(int x) {
        queueA.add(x);
       
    }
    
    public int pop() {
        queueB= new LinkedList<>();
       while(queueA.size() >1){
            
            queueB.add(queueA.poll());
            
       }
       int val = queueA.poll();
        queueA= queueB;

       return val;
    }
    
    public int top() {
         queueB= new LinkedList<>();
       while(queueA.size() >1){
            
            queueB.add(queueA.poll());
            
       }
       int val = queueA.poll();
        queueA= queueB;
        queueA.add(val);

       return val;
    }
    
    public boolean empty() {
       return  queueA.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */