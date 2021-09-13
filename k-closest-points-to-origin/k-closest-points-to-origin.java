class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> dist(a) -dist(b));
        for(int [] point : points){
            queue.add(point);
        }
        int [][] ans = new int[k][2];
        k--;
        while(k>=0){
            ans[k]=queue.poll();
            k--;
        }
        return ans;
    }
    public int dist(int [] arr){
        return (arr[0]*arr[0])+(arr[1]*arr[1]);
    }
}