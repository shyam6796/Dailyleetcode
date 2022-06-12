class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
           TreeMap<Integer,Integer> map =new TreeMap<>();
            
        for(int i=0; i<profit.length; i++){
            map.put(difficulty[i],Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        
        int maxProift =0;
        int max=0;
        
        for(int i :map.keySet()){
            max =Math.max(map.get(i),max);
            map.put(i,max);
        }
        
        for(int w :worker){
            if( map.floorKey(w) ==null)continue;
            maxProift += map.get(map.floorKey(w));
        }
        
        return maxProift; 
    }
}