class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m =grid.length;
        int n =grid[0].length;
         //System.out.println(m +"  " +n + "  "+k);
        boolean visited[][][] =new boolean[m][n][k+1];
        Queue<int[]> queue =new LinkedList<>();
        queue.add(new int[]{0,0,0});
        visited[0][0][0] =true;
        int dirs [][] ={{0,1},{1,0},{-1,0},{0,-1}};
        int lvl =0;
        
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                int curr[] =queue.poll();
                
                if(curr[0] ==m-1 && curr[1]== n-1){
                    return lvl;
                }
                for(int dir[] :dirs){
                           
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    int newK =curr[2];
                    //System.out.println(newX +"  " +newY + "  "+newK);
                    if(newX < 0 || newX >=m || newY < 0 || newY >=n || visited[newX][newY][newK]) continue;
                    
                    if(grid[newX][newY] ==1) newK++;
                    
                    if(newK <=k && !visited[newX][newY][newK]){
                        visited[newX][newY][newK] =true;
                        queue.add(new int[]{newX,newY,newK});
                        
                    }
                    
                }
            }
            lvl++;
        }
        return -1;
    }
}