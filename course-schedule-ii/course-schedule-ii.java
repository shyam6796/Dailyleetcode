class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Map<Integer,List<Integer>> prereqsPerCourse =new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> inPath = new HashSet<>();
        
      for(int i = 0; i < numCourses; ++i) {
            prereqsPerCourse.put(i, new ArrayList<>());
        }
        
        for(int[] prerequisite: prerequisites) {
            prereqsPerCourse.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        List<Integer> order = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(!visited[i]) {
                dfs(i, prereqsPerCourse, visited, inPath, order);
            }
        }
          
        if(order.size() == numCourses) {
            int[] finalOrder = new int[numCourses];
            for(int i = 0; i < numCourses; ++i) {
                finalOrder[i] = order.get(i);
            }
            return finalOrder;
        } else { // Cycle present order.size() > numCourses
            return new int[0];
        }
        
    }
    
    public void dfs(int node,Map<Integer,List<Integer>> prereqsPerCourse ,boolean[] visited, HashSet<Integer> inPath, List<Integer> order){
            inPath.add(node);
            visited[node] = true;
        
            for(int neighbor: prereqsPerCourse.get(node)){
            /* If true, no cycle */
            if(!inPath.contains(neighbor)) {
                if(!visited[neighbor]) {
                    dfs(neighbor, prereqsPerCourse, visited, inPath, order);
                }
            } else {
                order.add(0, neighbor);
                break;
            }
        }
         inPath.remove(node);
        order.add(0, node);
    }
     
       
}