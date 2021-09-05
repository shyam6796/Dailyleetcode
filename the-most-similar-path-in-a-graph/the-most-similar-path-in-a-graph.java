class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
       int k = targetPath.length, dp[][] = new int[k][n];//dp[a][b]: cost of choosing at position a the city b
        for(int i = k-1; i >= 0; --i){
            Arrays.fill(dp[i],k);
            for(var e : roads){
                for(var r : new int[][]{{e[0],e[1]},{e[1],e[0]}}){
                    int cost = Math.min(k,
                        (i+1 >= k ? 0 : dp[i+1][r[1]]) + 
                        (names[r[0]].equals(targetPath[i]) ? 0 : 1));
                    dp[i][r[0]] = Math.min(dp[i][r[0]], cost);
                }
            }
        }
        var ans = new Integer[k];
        for(int i = 0; i < k; ++i){
            ans[i] = -1;
            for(var e : roads){
                for(var r : new int[][]{{e[0],e[1]},{e[1],e[0]}}){
                    if ((i-1 < 0 || ans[i-1] == r[0]) && 
                        (ans[i] == -1 || dp[i][r[1]] < dp[i][ans[i]])){
                        ans[i] = r[1];
                    }
                }
            }
        }
        return Arrays.asList(ans);
    }
}