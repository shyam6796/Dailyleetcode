class Solution {
    int [][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
    public int swimInWater(int[][] grid) {
         
           
          
        int m =grid.length;
        int n=grid[0].length;
        int dist[][] = new int[m][n];
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            return Integer.compare(a[2],b[2]);
        });
        queue.add(new int[]{0,0,grid[0][0]});
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        
        while(!queue.isEmpty()){
            int [] curr =queue.poll();
            int x = curr[0];
            int y = curr[1];
            int time =curr[2];
            
            for(int dir[] : dirs){
               
                int nx =x+dir[0];
                int ny =y+dir[1];
                
                if(nx <0 || nx >=m ||ny <0 || ny >=n)continue;
                
                int rem = Math.max(0,grid[nx][ny]-time);
                
                if(rem +time <dist[nx][ny]){
                    dist[nx][ny]=rem+time;
                    queue.add(new int[]{nx,ny,dist[nx][ny]});
                }
            }
        }
        
        return dist[m-1][n-1] ==Integer.MAX_VALUE ? 0 : dist[m-1][n-1];
    }
}