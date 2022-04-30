class Solution {
 
    int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dist[][] =new int[m][n];
         int reach[][] =new int[m][n];
        int totalBuilding=0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    if(!helper(grid,dist,reach,i,j))return -1;
                    totalBuilding++;
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(dist[i][j] <ans && reach[i][j]==totalBuilding){
                        ans= dist[i][j];
                    } 
            }
        }
        return ans==Integer.MAX_VALUE ? -1 :ans;
    }
    public boolean helper(int [][] grid, int [][] dist, int [][] reach, int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][] =new boolean[m][n];
        Queue<int[]>queue =new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j]=true;
        int d=0;
        while(!queue.isEmpty()){
            d++;
            int size=queue.size();
            for(int k=0; k<size; k++){
                int []curr =queue.poll();
                for(int [] dir :dirs){
                    int x= curr[0]+dir[0];
                    int y= curr[1]+dir[1];
                    if(x < 0 || x>=m || y <0 || y >=n ||grid[i][j] ==2 || visited[x][y] )continue;
                     if(grid[x][y]==0){
                        reach[x][y]++;
                       dist[x][y] += d;
                        queue.add(new int[]{x,y});
                    }
                    visited[x][y]=true;
                }
            }
        }
        
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==1 && !visited[row][col])return false;
            }
        }
        return true;
    }
}