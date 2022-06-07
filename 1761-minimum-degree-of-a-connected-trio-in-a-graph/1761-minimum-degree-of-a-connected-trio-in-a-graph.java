class Solution {
    public int minTrioDegree(int n, int[][] edges) {
         HashSet<Integer>[] adjList = new HashSet[n+1];
        
        for(int i = 1; i <=n; i++)
            adjList[i] = new HashSet<>();
        
        for(int[] edge: edges) {
            adjList[edge[0] ].add(edge[1] );
            adjList[edge[1] ].add(edge[0]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(!adjList[i].contains(j)) // optimisation 
                    continue;
                for(int k = j + 1; k <= n; k++)
                     if(adjList[j].contains(k) && adjList[i].contains(k))
                         min = Math.min(min, adjList[i].size() + adjList[j].size() + adjList[k].size() - 6);
            }
        }
        
        return min == Integer.MAX_VALUE? -1: min;
    }
}