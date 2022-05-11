class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) -> dist(b) -dist(a));
        
        for(int point[] : points){
            queue.add(point);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int d[][] =new int[k][2];
        int index =0;
        while(index<k){
            d[index++]=queue.poll();
        }
        return d;
        
    }
    public int dist(int []a){
        return a[0]*a[0] +a[1]*a[1];
    }
}