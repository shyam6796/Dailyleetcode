class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid ==null ||grid[0] ==null || grid[0][0]==1)return -1;
        int m =grid.length;
        int n =grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        Queue<int[]> queue =new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] =true;
        int steps =0;
        while(!queue.isEmpty()){
            int size  =queue.size();
            steps++;
            for(int i=0; i<size; i++){
                int[] curr=queue.poll();
                if(curr[0] ==m-1 && curr[1]==n-1){
                    return steps;
                }
                for(int []dir : dirs){
                    int x =dir[0] +curr[0];
                    int y =dir[1] +curr[1];
                    
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] !=1 && !visited[x][y]){
                        visited[x][y] =true;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        return -1;
    }
}