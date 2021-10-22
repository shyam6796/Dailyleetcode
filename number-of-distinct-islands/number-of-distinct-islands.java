class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid ==null || grid.length==0)return 0;
        Set<String> path  = new HashSet<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                 if(grid[i][j]==1){
                    String s= helper(grid,i,j,"X");
                    path.add(s);
                 }
            }
        }
        return path.size();
    }
    
    public String helper(int grid[][], int i, int j, String  temp){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]==0){
            return "O";
        }
        grid[i][j]=0;
        String left =helper(grid,i,j-1,"L");
        String right =helper(grid,i,j+1,"R");
        String up =helper(grid,i-1,j,"U");
        String down =helper(grid,i+1,j,"D");
       
        
        return temp+left+right+up+down;
    }
}