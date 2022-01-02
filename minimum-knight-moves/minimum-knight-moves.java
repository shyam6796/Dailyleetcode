class Solution {
    public int minKnightMoves(int x, int y) {
            
        if (x == 0 && y == 0) {
            return 0;
        }
        
        int minimumMoves = 0;
        int[][] directions = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        boolean[][] visited = new boolean[301][301];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        x =Math.abs(x);
        y =Math.abs(y);
        
        while(!queue.isEmpty()){
            ++minimumMoves;
            int size =queue.size();
            
            for(int i=0; i<size; i++){
                int[] curr =queue.poll();
                
                    for(int [] dir :directions){
                        int a = Math.abs(curr[0]+dir[0]);
                        int b = Math.abs(curr[1]+dir[1]);
                        
                        if(x ==a && y ==b){
                            return minimumMoves;
                        }
                        if(!visited[a][b]){
                            visited[a][b] =true;
                            queue.add(new int[]{a,b});
                        }
                    }
            }
            
        }
        
        
        
        return -1;
    }
}