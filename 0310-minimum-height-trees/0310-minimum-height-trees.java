class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list =new ArrayList<>();
        if(n==1){
            list.add(0);
            return list;
        }
        Queue<Integer> queue =new LinkedList<>();
        Map<Integer,List<Integer>> map =new HashMap<>();
        int degree[] =new int[n];

        for(int i=0;i < n; i++)map.put(i,new ArrayList<>());

        for(int edge[] :edges){
            int u =edge[0];
            int v =edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        for(int i=0; i < n; i++){
            if(degree[i]==1){
                queue.add(i);
            }
            
        }
         int processed = 0;
        while(n - processed > 2){
            int size =queue.size();
               processed += size;
            for(int i =0; i < size; i++){
                int curr =queue.poll();
                for(int adj : map.get(curr)){
                    degree[adj]--;
                    if(degree[adj]==1)queue.add(adj);
                }
            }

        }

        list.addAll(queue);
        return list;
    }
}