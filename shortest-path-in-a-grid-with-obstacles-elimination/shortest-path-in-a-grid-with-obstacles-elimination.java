class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m =grid.length, n=grid[0].length;
        int [][] visited = new int[m][n];
        for(int [] i : visited){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        visited[0][0]=0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        int step=0;
        int [][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int size =q.size();
            for(int i=0; i<size; i++){
                int []cur =q.poll();
                int r =cur[0], c=cur[1];
                if(r==m-1 && c==n-1)return step;
                for(int dir[] : dirs){
                   int row =r +dir[0];
                   int col =c +dir[1];
                   if(row >=0 && row < m && col >=0  && col<n){
                       int o  = cur[2] + grid[row][col];
                        if(o >= visited[row][col] || o >k )continue;
                        visited[row][col] = o;
                       q.offer(new int[]{row,col,o});
                   }
                    
                }
            }
            step++;
        }
        return -1;
    }
}