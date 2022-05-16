class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m =grid.length-1;
        int n =grid[0].length-1;
        boolean visited[][][] = new boolean[m+1][n+1][k+1];
        Queue<int[]> queue = new LinkedList<>();
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        queue.add(new int[]{0,0,0});
        visited[0][0][0]=true;
        int steps =0;
        while(!queue.isEmpty()){
            int size =queue.size();
           
            for(int i=0; i<size; i++){
                int curr[] = queue.poll();
                if(curr[0]==m && curr[1]==n){
                    return steps;
                }
                for(int dir[] : dirs){
                    int newX =curr[0]+dir[0];
                    int newY =curr[1]+dir[1];
                    int newK =curr[2];
                    if(newX >=0 && newX <= m && newY >=0 && newY <= n && !visited[newX][newY][newK]){                 
                        if(grid[newX][newY]==1){
                            newK++;
                        }
                        if(newK <= k && !visited[newX][newY][newK]){
                            visited[newX][newY][newK] =true;
                            queue.add(new int[]{newX,newY,newK});
                        }
                        
                        
                    }
                }
            }
             steps++;
        }
        return -1;
    }
}