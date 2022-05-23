class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,List<Integer>> map =new HashMap<>();
        int ans [] = new int[adjacentPairs.length+1];
        LinkedList<Integer> queue =new LinkedList<>();
         Set < Integer > seen = new HashSet < > ();
        
        buildGraph(map,adjacentPairs);
        
        for(int i: map.keySet()){
            if(map.get(i).size()==1){
                queue.add(i);
                break;
            }
        }
        int index=0;
        while(!queue.isEmpty()){
            int val =queue.poll();
            ans[index++] =val;
            seen.add(val);
            
            for(int i : map.get(val)){
                if(!seen.contains(i)) queue.add(i);
            }
            
        }
        
        return ans;
    }
    
    public void buildGraph(Map<Integer,List<Integer>> map,int[][] adjacentPairs){
        
        for(int curr[] : adjacentPairs){
            if(!map.containsKey(curr[0])) map.put(curr[0],new ArrayList<>());
            if(!map.containsKey(curr[1])) map.put(curr[1],new ArrayList<>());
            map.get(curr[0]).add(curr[1]);
            map.get(curr[1]).add(curr[0]);
        }
    }
}