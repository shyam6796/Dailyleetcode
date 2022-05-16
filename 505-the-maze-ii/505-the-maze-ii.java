class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[start[0]][start[1]] = 0;
        Queue<int[]> minheap = new PriorityQueue<>((x, y) -> Integer.compare(visited[x[0]][x[1]], visited[y[0]][y[1]]));
        minheap.offer(start);
        
        while (!minheap.isEmpty()) {
            int[] cur = minheap.poll();
            int x = cur[0], y = cur[1];
            if (x == destination[0] && y == destination[1]) {
                return visited[x][y];
            }
            for (int[] dir: DIRECTIONS) {
                int xx = x, yy = y, dd = visited[x][y];
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                    dd++;
                }
                xx -= dir[0];
                yy -= dir[1];
                dd--;
                
                if (dd < visited[xx][yy]) {
                    visited[xx][yy] = dd;
                    minheap.offer(new int[]{xx, yy});
                }
            }
        }
        return -1;
    }
}