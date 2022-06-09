class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)return informTime[0];
        int time[]  = new int[n];
        HashMap<Integer,List<Integer>> map =new HashMap<>();
        for(int i=0; i<manager.length; i++){
             if(manager[i]==-1 )continue;
            if(!map.containsKey(manager[i])){
                map.put(manager[i],new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        System.out.println(map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            int infoTime = informTime[v];
            if(map.get(v) != null){
                for(int u : map.get(v)){
                    time[u] = time[v] + infoTime;
                    queue.add(u);
                }
            }
        }
        
         int maxTime = 0;
        for(int t : time)
            maxTime = Math.max(t, maxTime);
        return maxTime;
       
    }
}