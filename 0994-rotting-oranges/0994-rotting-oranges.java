class Solution {
    public int orangesRotting(int[][] grid) {
        int max =0;

        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                    if(grid[i][j] ==2){
                        helper(grid,i,j,2);
                    }
            }
        }

        for(int i =0; i < grid.length; i++){
            for(int j=0; j <grid[0].length; j++){
                if(grid[i][j]==1)return -1;
                max = Math.max(grid[i][j],max);
            }
        }
        return max == 0 ? 0 : max-2;
    }

    public void helper(int [][] grid, int i, int j ,int id){
        if(i < 0 || j < 0 || i >=grid.length || j >= grid[0].length || (grid[i][j] < id && grid[i][j] !=1))return ;
        grid[i][j] = id;

        helper(grid,i+1,j,id+1);
        helper(grid,i,j+1,id+1);
        helper(grid,i-1,j,id+1);
        helper(grid,i,j-1,id+1);

    }
}