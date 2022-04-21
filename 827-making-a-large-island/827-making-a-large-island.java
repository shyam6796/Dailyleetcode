class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer,Integer> map = new HashMap<>();
        int islandId =2;
        int area=0;
        int dirs[][] ={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] ==1){
                    int ans =DFS(grid,i,j,islandId);
                    area=Math.max(area,ans);
                    map.put(islandId++,ans);
                }
            }
        }
        
         for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    for(int [] dir :dirs){
                        int x =dir[0]+i;
                        int y =dir[1]+j;
                        
                        if(x<0 || x>=grid.length || y<0 || y >=grid[0].length ||grid[x][y]==0) continue;
                        set.add(grid[x][y]);
                    }
                    
                    int sum=1;
                    for(int k :set){
                        sum += map.get(k);
                    }
                    area =Math.max(sum,area);
                }
            
            }
         }
        return area;
    }
    
    public int DFS(int [][] grid, int i, int j ,int islandId){
        if(i<0 || i>=grid.length || j<0 || j >=grid[0].length || grid[i][j] !=1){
            return 0;
        }
        grid[i][j] =islandId;
        int left =DFS(grid,i,j+1,islandId);
        int right =DFS(grid,i,j-1,islandId);
        int up =DFS(grid,i-1,j,islandId);
        int down =DFS(grid,i+1,j,islandId);
        
        return up+down+left+right+1;
    }
}