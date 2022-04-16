class Solution {
    int[] dx = {1 , 0 , -1 , 0};
    int[] dy = {0 ,1 , 0 , -1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dis = new int[n][n];
        
        for(int i = 0 ; i< n ; i++){
            Arrays.fill(dis[i] , Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1 , int[] a2){
                return Integer.compare(a1[2] , a2[2]);
            }
        });
        
        pq.add(new int[]{0 , 0 ,grid[0][0]});
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int x = arr[0] , y = arr[1] , time = arr[2];
            for(int i = 0; i< 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }
                
                int rem = Math.max(0 , grid[nx][ny] - time);
                
                if(rem + time < dis[nx][ny]){
                    dis[nx][ny] = rem + time;
                    pq.add(new int[]{nx , ny , dis[nx][ny]});
                }
    
            }            
        }
        
        
        return dis[n-1][n-1] == Integer.MAX_VALUE ? 0 : dis[n-1][n-1] ;
        
        
    }
}
