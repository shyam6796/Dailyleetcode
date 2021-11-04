class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int max = 0;
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            int rows = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int total = rows + cols[j];
                    for (int k = j + 1; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            total++;
                        }
                    }
                    for (int k = i + 1; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            total++;
                        }
                    }

                    max = Math.max(max, total);
                } else if (grid[i][j] == 'W') {
                    rows = 0;
                    cols[j] = 0;
                } else {
                    rows++;
                    cols[j]++;
                }
            }
        }

        return max;
    }
}