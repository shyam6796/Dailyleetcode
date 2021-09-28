class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums.isEmpty()) return new int[0];
    
        int[] range = new int[]{0, Integer.MAX_VALUE};
    
         PriorityQueue<LinkedList<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.peek() - b.peek()));
        PriorityQueue<LinkedList<Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.peek() - a.peek()));
    
         for(List<Integer> list: nums) {
            LinkedList<Integer> linkedList = new LinkedList<>(list);
            minHeap.add(linkedList);
            maxHeap.add(linkedList);
            }
    
         while(minHeap.size() == nums.size()) {
            LinkedList<Integer> minList = minHeap.poll();
            LinkedList<Integer> maxList = maxHeap.poll();
        
             int min = minList.getFirst();
                 int max = maxList.getFirst();
        
             minList.removeFirst();
        
             if(minList.size() > 0) {
                minHeap.add(minList);
                 maxHeap.add(maxList);
                 if(!maxList.equals(minList)) {
                    maxHeap.remove(minList);
                    maxHeap.add(minList);
            }
            }
            if((range[1] - range[0]) > (max - min)) {
                range[0] = min;
                range[1] = max;
            }
        }
    
    return range;
    }
}