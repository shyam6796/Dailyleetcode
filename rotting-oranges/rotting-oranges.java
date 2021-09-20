class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2)  dfs(grid,i,j,2);
            }
        }
        
         for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
                total =Math.max(total,grid[i][j]);
            }
        }
     
        return total==0 ? 0 :total-2;
        
    }
    public void dfs(int [][] grid, int i, int j, int count){
        if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length ||( grid[i][j]<count && grid[i][j] !=1)){
            return;
        }
        grid[i][j]=count;
        dfs(grid,i+1,j,count+1);
        dfs(grid,i,j+1,count+1);
        dfs(grid,i,j-1,count+1);
        dfs(grid,i-1,j,count+1);
        
        
    }
}