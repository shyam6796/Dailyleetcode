class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        HashMap<Integer,Set<Integer>> map =new HashMap<>();
        
        for(int i=1; i<=n; i++){
            map.put(i,new HashSet<>());
        }
        
        for(int edge[] : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int min =Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(!map.get(i).contains(j)) continue;
                
                for(int k=j+1; k<=n; k++){
                    if(map.get(j).contains(k) && map.get(k).contains(i)){
                        min = Math.min(map.get(i).size() +map.get(j).size() + map.get(k).size() -6, min);
                    }
                }
            }
        }
        return min ==Integer.MAX_VALUE ? -1 :min;
    }
}