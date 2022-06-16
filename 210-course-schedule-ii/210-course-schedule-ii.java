class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list =new ArrayList<>();
        Set<Integer> path =new HashSet<>();
        List<Integer> order =new ArrayList<>();
        boolean visited [] = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        
        for(int preq[] : prerequisites){
            list.get(preq[1]).add(preq[0]);
        }
        
        for(int i=0; i<numCourses; i++){
                if(!visited[i]){
                    DFS(i,list,path,order,visited);
                }
        }
        
        if(order.size() !=numCourses){
            return new int[0];
        }
        
        int result [] =new int[order.size()];
        for(int i =0; i<order.size(); i++){
            result[i] =order.get(i);
        }
        
        return result;
    }
    
    public void DFS(int node, List<List<Integer>> list, Set<Integer> path, List<Integer> order, boolean [] visited){
        visited[node] =true;
        path.add(node);
        for(int neg :list.get(node)){
            if(!path.contains(neg)){
                if(!visited[neg]){
                    DFS(neg,list,path,order,visited);
                }
            }else{
                order.add(0,neg);
            }
        }
        path.remove(node);
        order.add(0,node);
    }
}