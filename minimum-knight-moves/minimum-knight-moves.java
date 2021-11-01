class Solution {
    public int minKnightMoves(int x, int y) {
            
        if (x == 0 && y == 0) {
            return 0;
        }
        
        int minimumMoves = 0;
        int[][] directions = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        boolean[][] visited = new boolean[301][301];
        Queue<int[]> queue = new LinkedList<> ();
        
        x = Math.abs (x);
        y = Math.abs (y);
        visited[0][0] = true;
        queue.offer (new int[] {0, 0});
        
        while (!queue.isEmpty ()) {
            ++minimumMoves;
            int size = queue.size ();
            
            while (size-- != 0) {
                int[] curr = queue.poll ();
                
                for (int[] direction : directions) {
                    int row = Math.abs (curr[0] + direction[0]);
                    int col = Math.abs (curr[1] + direction[1]);
                    
                    if (row == x && col == y) {
                        return minimumMoves;
                    }
                    else if (!visited[row][col]) {
                        visited[row][col] = true;
                        queue.offer (new int[] {row, col});
                    }
                }
            }
        }
        
        return -1;
    }
}