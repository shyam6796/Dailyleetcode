class Solution {
    public int connectSticks(int[] sticks) {
      PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i :sticks ){
             queue.add(i);
        }
         int cost=0;
        while(queue.size()>1){
            int a =queue.poll();
            int b =queue.poll();
            cost += a+b;
            queue.add(a+b);
        }
       
        return cost;
    }
}