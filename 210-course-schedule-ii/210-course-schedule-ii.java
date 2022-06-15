class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> inPath =new HashSet<>();
        List<Integer> order =new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int prerequisite[]  : prerequisites){
                map.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[]visited = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                DFS(i,visited,order,map,inPath);
            }    
        }
        if(order.size()==numCourses){
            int arr[] =new int[order.size()];
            for(int i=order.size()-1; i>=0; i--){
                arr[i]=order.get(i);
            }
            return arr;
        }else{
            return new int[0];
        }
        
    }
    
    public void DFS(int node,boolean [] visited , List<Integer> order,  Map<Integer,List<Integer>> map,Set<Integer> inPath){
        visited[node] =true;
        inPath.add(node);
        
        //if(map.get(node) ==null)return;
        for(int neg : map.get(node)){
          
            if(!inPath.contains(neg)){
                if(!visited[neg]){
                    DFS(neg,visited,order,map,inPath);
                }
            }else{
                order.add(0,neg);
                break;
            }
        }
        order.add(0,node);
        inPath.remove(node);
    }
}