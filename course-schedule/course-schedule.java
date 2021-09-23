class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> list =new ArrayList<>();
            for(int i=0; i<numCourses; i++){
                list.add(new ArrayList<>());
            }
            
            for(int [] prerequisite : prerequisites){
                list.get(prerequisite[1]).add(prerequisite[0]);
            }
        
        boolean visited[] = new boolean[numCourses];
        List<Integer> path = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<numCourses; i++){
            if(!visited[i])
            dfs(list,visited,path,set,i);
        }
        return path.size() == numCourses;
            
    }
    public void  dfs(List<List<Integer>> list,boolean visited[], List<Integer> path,HashSet<Integer> set, int node){
        set.add(node);
        visited[node]=true;
        
        for(int neg : list.get(node)){
            if(!set.contains(neg)){
                if(!visited[neg]){
                    dfs(list,visited,path,set,neg);
                }
            }else{
                path.add(0,neg);
                break;
            }
        }
        path.add(0,node);
        set.remove(node);
    }
}