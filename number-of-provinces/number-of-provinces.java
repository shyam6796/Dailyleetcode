class Solution {
    public int findCircleNum(int[][] isConnected) {
         boolean []visited =new boolean[isConnected.length];
        int ans=0;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int[][] isConnected, boolean [] visited, int i){
        if( visited[i]==true) return;
        visited[i]=true;
        for(int j=0; j<isConnected[i].length; j++){
            if(isConnected[i][j]==1){
                dfs(isConnected, visited, j);
            }
        }
    }
}