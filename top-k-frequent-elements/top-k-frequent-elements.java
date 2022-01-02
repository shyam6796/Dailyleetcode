class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map   =new HashMap<>();
        int ans [] = new int [k];
        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b) -> map.get(b) -map.get(a));
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        queue.addAll(map.keySet());
        
        for(int i=0; i<k; i++){
            ans[i] =queue.poll();
        }
        
        return ans;
    }
}