class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        int count =0;
        boolean [] arr = new boolean[n];
        for(int i=0; i<n; i++){
            if(!arr[i]){
                dfs(arr,i,list);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(boolean []arr, int i, List<List<Integer>> list){
            if(arr[i] ==true)return;
            arr[i] =true;
            List<Integer> neg  = list.get(i);
            for(int k : neg){
              
                dfs(arr,k,list);
            }
    }
}