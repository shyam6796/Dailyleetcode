class Solution {
    public int[] findBall(int[][] grid) {
       
          int res[]=new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++){
            res[j]=check(grid,0,j);
        }
        return res;
    }
    int check(int [][]grid,int i,int j){ 
        if(j<0|| j>=grid[0].length) return -1;
        if(i==grid.length) return j;
        if(j<grid[0].length-1 && grid[i][j]==1 && grid[i][j+1]==-1) return -1;
        if(j>0 && grid[i][j]==-1 && grid[i][j-1]==1) return -1;
        if(grid[i][j]==1){
            return check(grid,i+1,j+1);
        }
        else{
            return check(grid,i+1,j-1);
        }
    }
}