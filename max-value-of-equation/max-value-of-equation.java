class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>>queue = new PriorityQueue<>((a,b) -> b.getKey()- a.getKey());
        int max =Integer.MIN_VALUE;
        
        for(int [] point : points){
            while(!queue.isEmpty() &&  point[0] - queue.peek().getValue() >k){
                queue.poll();
            }
            if(!queue.isEmpty()){
                max = Math.max(max, point[0] + point[1] + queue.peek().getKey());
            }
            
            queue.add(new Pair<Integer, Integer>(point[1]- point[0], point[0]));
        }
        return max;
    }
}