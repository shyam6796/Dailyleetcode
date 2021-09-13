class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean [] visited =new boolean[n];
        int ans=0;
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge :edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(visited, graph,i);
                ans++;
            }
        }
        return ans;
        
    }
    
    public void dfs(boolean [] visited, List<List<Integer>> graph, int i){
        if(visited[i]==true)return;
        visited[i]=true;
        List<Integer> neg =graph.get(i);
        for(int j=0; j<neg.size(); j++){
            if(!visited[neg.get(j)]){
                dfs(visited,graph,neg.get(j));
            }
        }
        
    }
}