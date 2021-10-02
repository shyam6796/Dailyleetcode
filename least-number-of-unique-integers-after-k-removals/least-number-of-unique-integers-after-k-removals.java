class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
          HashMap<Integer,Integer> map = new HashMap<>();
        
        //get count of all the elements
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) +1);
        }
           PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
         for ( int i :map.keySet()){
                  int key = i;
                  int val = map.get(i);
        
                pq.add(new int[]{key,val});
            }
        for(int i=0; i < k ;i++ ){
                   int[] ele = pq.poll();
                   if(ele[1] > 1){
                       ele[1]--;
                       pq.add(ele);
                   }
                }
    
        
        
        return pq.size() ;
    }
}