class Solution {
    int totalCost =0;
    public int[] minEdgeReversals(int n, int[][] edges) {
        int ans[] = new int[n];
        int cost[] = new int[n];
        int depth[] =new int[n];
        boolean []visited =new boolean[n];
        Map<Integer,List<Pair<Integer,Integer>>> map = new HashMap<>();

        for(int i =0; i <n; i++)map.put(i,new ArrayList<>());

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            map.get(u).add(new Pair(v, 0));
            map.get(v).add(new Pair(u, 1));
        }

        DFS(map,cost,depth,visited,0,0);
        ans[0]= totalCost;

        for(int i =1; i < n; i++){
            int val1 = depth[i] -cost[i];
            int val2 = totalCost -cost[i];
            ans[i] = val1 + val2;
        }
        return ans;
    }

    public void DFS(Map<Integer,List<Pair<Integer,Integer>>> map, int cost[], int depth[], boolean []visited, int node,int currdepth){
        depth[node] =currdepth;
        visited[node] =true;

        for(Pair<Integer,Integer> pr : map.get(node)){
            if(!visited[pr.getKey()]){
                cost[pr.getKey()] = cost[node] + pr.getValue();
                DFS(map, cost, depth, visited, pr.getKey(), currdepth+1);
                totalCost +=pr.getValue();
            }
            
        }
    }
}