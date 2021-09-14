class MedianFinder {
    PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
         minHeap =new PriorityQueue<>();
         maxHeap =new PriorityQueue<>((a,b) -> b-a);
        
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size () < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (double)(minHeap.peek() + maxHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */