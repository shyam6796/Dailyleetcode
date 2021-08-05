class Solution {
    public int getMaximumGold(int[][] grid) {
             int[][]visited=new int[grid.length][grid[0].length];
         int sum=0,max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    sum=dfs(grid,visited,i,j);
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
    int dfs(int[][]grid,int [][]visited,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j]==1||grid[i][j]==0)  return 0;
        
        visited[i][j]=1;
        
        int up=dfs(grid,visited,i+1,j);
        int down=dfs(grid,visited,i-1,j);
        int left=dfs(grid,visited,i,j-1);
        int right=dfs(grid,visited,i,j+1);
        
        visited[i][j]=0;
        return grid[i][j]+Math.max(Math.max(up,down),Math.max(left,right));
        
    }
}