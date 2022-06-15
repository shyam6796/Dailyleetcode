class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int arr[][] = new int[speed.length][2];
         long mod = 1000_000_007;
        for(int i=0; i<speed.length; i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }
        Arrays.sort(arr,(a,b) -> b[1] - a[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long runnigSum=0;
        long max=0;
        for(int i=0; i<arr.length; i++){
            if(queue.size() ==k){
              runnigSum-=queue.poll();
            }
            runnigSum +=arr[i][0];
            queue.add(arr[i][0]);
            max =Math.max(runnigSum*arr[i][1],max);
        }
        return (int)(max%mod);
    }
}