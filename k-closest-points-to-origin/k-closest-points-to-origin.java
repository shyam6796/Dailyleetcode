class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> dist(a) -dist(b));
        for(int [] point : points){
            queue.add(point);
        }
       int [][]ans =new int[k][2];
        
        for(int i=0; i<k; i++){
            ans[i] =queue.poll();
        }
        return ans;
    }
    public int dist(int [] arr){
        return (arr[0]*arr[0])+(arr[1]*arr[1]);
    }
}