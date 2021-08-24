class Solution {
    public int removeStones(int[][] stones) {
       Map<Integer,List<Integer>> map =new HashMap<>();
        
        for(int [] stone :stones){
                       map.computeIfAbsent(stone[0], x -> new ArrayList<>()).add(~stone[1]);
            map.computeIfAbsent(~stone[1], x -> new ArrayList<>()).add(stone[0]);
            // System.out.println(map);

        }
       
        int component = 0;
        Set<Integer> visited = new HashSet<>();
        for (int [] stone : stones) {
            for (int i=0; i<2; i++) {
                int current = i == 0 ? stone[0] : ~stone[1];
                if (!visited.contains(current)) {
                    component += 1;
                    dfs(map, visited, current);
                }
            }
        }
        return stones.length - component;              
    }
                
    public void dfs(Map<Integer,List<Integer>> map, Set<Integer> visited, int C){
        if(visited.contains(C)){
            return;
        }
        visited.add(C);
        List<Integer>children = map.get(C);
        if(children ==null)return;
        for(int i : children){
            if(!visited.contains(i)){
                dfs(map,visited,i);
            }
        }
    }
}