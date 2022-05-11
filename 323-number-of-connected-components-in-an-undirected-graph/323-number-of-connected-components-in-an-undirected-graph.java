class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean visited[] =new boolean[n];
        int count =0;
        
         List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(list,i,visited);
                count++;
            }
        }
        return count;
    }
    
    public void DFS(List<List<Integer>> list, int n, boolean [] visited){
        visited[n] =true;
        
        for(int i : list.get(n)){
            if(!visited[i]){
                 DFS(list,i,visited);
            }
        }
    }
}