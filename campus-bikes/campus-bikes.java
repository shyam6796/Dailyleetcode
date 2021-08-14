class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
          
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] != b[2] ?  a[2] - b[2] : (a[0] !=  b[0] ? a[0] - b[0] : a[1] - b[1]));
        
        for(int i=0; i < workers.length; i++){
            for(int j=0; j < bikes.length; j++){
                pq.offer(new int[]{i, j, dist(workers[i], bikes[j])});  // worker, bike, distance
            }
        }
                 
        
        int[] workerStatus = new int[workers.length];
        int[] bikeStatus = new int[bikes.length];
        
        int[] res = new int[workers.length];
        
        int assigned = 0;
        while(assigned < workers.length){
            int[] a = pq.poll();
          //  System.out.println(a[0]+" "+a[1]+ " "+ a[2]);
            if(workerStatus[a[0]] == 0 && bikeStatus[a[1]] == 0){
                res[a[0]] = a[1];
                
                workerStatus[a[0]] = 1;
                bikeStatus[a[1]] = 1;
                assigned++;
            }
        }
              
        return res;
    }
    
    private int dist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
} 
