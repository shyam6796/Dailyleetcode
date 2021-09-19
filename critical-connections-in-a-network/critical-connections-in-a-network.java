class Solution {
    List<List<Integer>> result =new ArrayList<>();
    int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<connections.size(); i++){
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        boolean[] visited =new boolean[n];
        int timestamp[]  = new int[n];
        dfs(graph,visited,timestamp,0,-1);
        return result;
    }
    public void dfs( List<List<Integer>> graph,  boolean[] visited, int timestamp[], int curr, int prev){
        visited[curr]=true;
        timestamp[curr]=time++;
        int currentTimeStamp = timestamp[curr];
        
        for(int neghbiour : graph.get(curr)){
                if(neghbiour == prev) continue;
                if(!visited[neghbiour]){
                    dfs(graph,visited,timestamp, neghbiour,curr); 
                }
            timestamp[curr] = Math.min(timestamp[curr], timestamp[neghbiour]);
                if(currentTimeStamp < timestamp[neghbiour])
                     result.add(Arrays.asList(curr, neghbiour));
        }
    }
}