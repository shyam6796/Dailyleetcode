class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
          int[] result = new int[workers.length];
     Set<Integer> workerSet = new HashSet<Integer>();
     Set<Integer> bikeSet = new HashSet<Integer>();
    
    for(int i =0; i<workers.length ;i++ ){
        workerSet.add(i);
    }
    for(int i =0; i<bikes.length ;i++ ){
        bikeSet.add(i);
    }
    
    Map<Integer, List> map = new HashMap<Integer, List>();
    
    for(int i =0; i<workers.length ;i++ ){
        for(int j =0; j<bikes.length ;j++){
            int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            if(!map.containsKey(distance)){
                List<int[]> list = new ArrayList<int[]>();
                list.add(new int[]{i,j});
                map.put(distance, list);
            }else{
                map.get(distance).add(new int[]{i,j});
            }
        }
    }
    
    for(int i =1; i<2000; i++){
        if(map.get(i)!=null){
            List<int[]> list = map.get(i);
            for(int j=0; j<list.size();j++){
                int[] pair  = list.get(j);
                if(workerSet.contains(pair[0]) && bikeSet.contains(pair[1])){
                    result[pair[0]] = pair[1];
                    workerSet.remove(pair[0]);
                    bikeSet.remove(pair[1]);
                }
            }
        }
    }
    
    return result;
    }
} 
