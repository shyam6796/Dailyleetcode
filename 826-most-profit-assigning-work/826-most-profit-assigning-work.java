class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        TreeMap<Integer,Integer> map =new TreeMap<>();
        
        for(int i=0; i<profit.length; i++){
            map.put(difficulty[i],Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        //System.out.println(map);
        
        
        int max = 0;
        for(int i :map.keySet()){
            max = Math.max(max,map.get(i));
            map.put(i,max);
        }
         //System.out.println(map);
        
        int prof=0;        
        for(int worker : workers){
            if(map.floorKey(worker) !=null) prof += map.get(map.floorKey(worker));
        }
        
        return prof;
    }
}