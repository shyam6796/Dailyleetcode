class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] +a[1]) -(b[0]+b[1]) );
        
        for(int i=0; i<nums1.length; i++){
            pq.add(new int[]{nums1[i],nums2[0],0});
        }
        
        for(int i=0; i<k && !pq.isEmpty(); i++){
            int [] curr =pq.poll();
            list.add(List.of(curr[0],curr[1]));
            int nextIndex =curr[2];
            if(nextIndex+1<nums2.length){
                pq.add(new int[]{curr[0],nums2[nextIndex+1],nextIndex+1});
            }
        }
        return list;
    }
}