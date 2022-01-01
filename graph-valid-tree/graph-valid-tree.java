class Solution {
    public boolean validTree(int n, int[][] edges) {
          if (edges.length != n - 1) return false;
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,list,set);
        
        return set.size() == n;
    }
    
    public void dfs(int curr,  List<List<Integer>> list,Set<Integer> set){
        if(set.contains(curr))return;
        set.add(curr);
        List<Integer> neg = list.get(curr);
        for( int i :neg){
            dfs(i,list,set);
        }
        
    }
}