class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();

        for(int i =0; i < isConnected.length; i++)list.add(new ArrayList<>());

        for(int i=0; i < n; i++){
            for(int j =0; j< isConnected[i].length; j++){
                if(i ==j)continue;
                if(isConnected[i][j] ==1) list.get(i).add(j);
            }
        }
        int count =0;
        boolean visited [] = new boolean[n];

        for(int i=0; i < n; i++){
            if(!visited[i]){
                DFS(list,i,visited);
                count++;
            }
        }
        return count;
    }

    public void DFS(List<List<Integer>> list, int node ,boolean [] visited){
        visited[node] =true;

        for(int neg : list.get(node)){
            if(!visited[neg]){
                DFS(list,neg,visited);
            }
        }
    }
}