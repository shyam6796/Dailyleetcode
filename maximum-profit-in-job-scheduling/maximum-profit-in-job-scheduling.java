class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int nums[][] = new int [profit.length][3];
        TreeMap<Integer,Integer> map =new TreeMap<>();
        map.put(0,0);
        for(int i=0; i<profit.length; i++){
           nums[i] = new int[] {startTime[i],endTime[i],profit[i]};
            
        }
        
        Arrays.sort(nums, (a,b) -> a[1]- b[1]);
        
        for(int i[] : nums){
            int val =i[2] + map.floorEntry(i[0]).getValue();
                if(val > map.lastEntry().getValue()){
                map.put(i[1],val);
            }
        }
        
        return map.lastEntry().getValue();
    }
}