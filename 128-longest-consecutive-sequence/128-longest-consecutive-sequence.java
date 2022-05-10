class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count =0;
        for(int i :nums){
            set.add(i);
        }
        
        for(int i :set){
            if(!set.contains(i-1)){
                 int currentNum = i;
                int streak = 1;
                while(set.contains(++currentNum)){
                streak++;
    
                }
                i= currentNum-1;
                count = Math.max(count,streak);
                 streak=0;
            }
            
            
           
        }
        
        return count;
    }
}