class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i < n; i++)list.add(new ArrayList<>());
        for(int edge[] : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

            return DFS(list,source,destination, new HashSet<>())   ;
    }
    public boolean DFS(List<List<Integer>> list, int node, int target, Set<Integer> set){
        if(node==target)return true;
        boolean flag =false;
        set.add(node);

        for(int neg : list.get(node)){
            if(!set.contains(neg)){
                flag = DFS(list,neg,target,set);
                if(flag)return flag;
            }
        }
        return false;
    }
}