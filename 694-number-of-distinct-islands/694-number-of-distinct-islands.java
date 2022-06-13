class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid==null ||grid.length==0)return 0;
        Set<String> set =new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    String s =DFS(grid,i,j,"X");
                    set.add(s);
                }
            }
        }
        return set.size();
    }
    
    public String DFS(int [][] grid, int i, int j, String curr){
        if(i <0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1){
             return "O";
        }
        grid[i][j]=2;
       
        String left = DFS(grid,i,j+1,"L");
        String right = DFS(grid,i,j-1,"R");
        String up = DFS(grid,i-1,j,"U");
        String down = DFS(grid,i+1,j,"D");
        
        return curr+left+right+up+down;
        
    }
}