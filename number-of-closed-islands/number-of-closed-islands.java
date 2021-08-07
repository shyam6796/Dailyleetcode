class Solution {
    public int closedIsland(int[][] grid) {
        if(grid ==null || grid.length ==0) return 0;
        int ans = 0, rows =grid.length, cols = grid[0].length;
        
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(grid[i][j]==0){
                    if(isClosed(grid,i,j,rows,cols)){
                    ans++;
                    }
                }
                
            }
        }
        return ans;
    }
    public boolean isClosed(int[][] grid, int i, int j ,int rows, int cols){
        if(grid[i][j] ==1 || grid[i][j]== -1) return true;
        if(isOnedge(i,j,rows,cols))return false;
        grid[i][j]=-1;
        
        boolean left = isClosed(grid,i,j+1,rows,cols);
        boolean right = isClosed(grid,i,j-1,rows,cols);
        boolean up = isClosed(grid,i-1,j,rows,cols);
        boolean down = isClosed(grid,i+1,j,rows,cols);
        
        return up && down && left && right;
    }
    
    public boolean isOnedge(int i, int j, int rows, int cols){
        if(i ==0 || i == rows -1 || j==0 || j==cols-1)return true;
        else return false;
    }
}