class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         if(grid ==null ||grid[0] ==null || grid[0][0]==1)return -1;
        int dirs [][] = {{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int steps =0;
        int m =grid.length;
        int n =grid[0].length;
        boolean visited[][] = new boolean[m][n];;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0]= true;
        while(!queue.isEmpty()){
            steps++;
            int size =queue.size();
            for(int i=0; i<size; i++){
                int [] curr =queue.poll();
                int x = curr[0];
                int y = curr[1];
                if(x==m-1 && y==n-1){
                    return steps;
                }
                for(int dir [] :dirs){
                    int newX = x+dir[0];
                    int newY = y+dir[1];
                    
                    if(newX >=0 && newX <m && newY >=0 && newY <n && grid[newX][newY] !=1 && !visited[newX][newY]) {
                         visited[newX][newY] =true;
                        queue.add(new int []{newX,newY});
                       
                    }   
                }
            }
        }
        return -1;
    }
}