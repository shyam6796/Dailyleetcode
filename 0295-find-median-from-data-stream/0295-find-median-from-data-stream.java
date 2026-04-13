class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap =new PriorityQueue<>();
        maxHeap =new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(maxHeap.size() > minHeap.size())minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        return (maxHeap.size() == minHeap.size()) ?(maxHeap.peek() + minHeap.peek())/2.0 : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */