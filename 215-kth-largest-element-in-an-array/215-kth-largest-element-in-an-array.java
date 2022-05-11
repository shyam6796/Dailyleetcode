class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        int ans =0;
        for(int i : nums){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }
        
       System.out.println(queue);
        return queue.poll();
    }
}