class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int arr[][] = new int[speed.length][2];
        long mod = 1000_000_007;
        for(int i=0; i<speed.length; i++){
            arr[i][0] =speed[i];
            arr[i][1] =efficiency[i];
        }
        
        Arrays.sort(arr,(a,b) -> b[1]-a[1]);
        PriorityQueue<Integer> queue =new PriorityQueue<>();
       long speedSum=0;
        long total=0;
        for(int a[] :arr){
            if(queue.size()==k){
                speedSum -=queue.poll();
            }
            speedSum +=a[0];
            queue.add(a[0]);
            total = Math.max(total, speedSum*a[1]) ;
        }
        return (int) (total % mod);
        
    }
}