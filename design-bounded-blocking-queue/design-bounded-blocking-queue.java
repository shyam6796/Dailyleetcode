class BoundedBlockingQueue {
   Queue<Integer> queue;
    int max;
    public BoundedBlockingQueue(int capacity) {
        queue= new LinkedList<>();
        max=capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized(queue){
        while(queue.size() == max)queue.wait();
        queue.add(element);
        queue.notify();
        }
       
        
    }
    
    public int dequeue() throws InterruptedException {
         synchronized(queue){
        while(queue.size() <= 0 )queue.wait();
        queue.notify();
        return queue.poll();
       
        }
    }
    
    public int size() {
        return queue.size();
    }
}