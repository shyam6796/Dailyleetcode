class Solution {
    int dirs [][] = {{1,0},{0,1},{-1,0},{0,-1}};
     int m,n;
    public int shortestDistance(int[][] grid) {
        m =grid.length;
        n =grid[0].length;
        int reach [][] =new int[m][n];
        int dist [][] =new int[m][n];
        int totalBuildings=0;
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    if(!BFS(grid,dist,reach,i,j))return -1;
                    totalBuildings++;
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] <ans && reach[i][j] ==totalBuildings){
                    ans =dist[i][j];
                }
            }
        }
        return ans ==Integer.MAX_VALUE ? -1 :ans;
    }
    
    public boolean BFS(int [][] grid, int [][]dist, int[][]reach, int x, int y){
        Queue<int[]> queue =new LinkedList<>();
        boolean visited[][] =new boolean[m][n];
        visited[x][y] =true;
        queue.add(new int []{x,y});
        int d=0;
        while(!queue.isEmpty()){
            d++;
            int size=queue.size();
            for(int i=0; i<size; i++){
                int [] curr= queue.poll();
                
                for(int dir [] :dirs){
                    int newX =curr[0]+dir[0];
                    int newY =curr[1]+dir[1];
                    
                    if(newX <0 || newX >=m || newY <0 || newY >=n ||grid[newX][newY]==2 || visited[newX][newY]) continue;
                    if(grid[newX][newY]==0){
                        dist[newX][newY] +=d;
                        reach[newX][newY]++;
                        
                        queue.add(new int[]{newX,newY});
                    }
                    visited[newX][newY]=true;
                    
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] ==1) return false;
            }
        }
        return true;
    }
}