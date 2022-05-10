class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int count=0;
        for(int i :set){
            if(!set.contains(i-1)){
                int currentNum = i;
                int streak = 1;
                while(set.contains(++currentNum)){
                streak++;
                }
                count =Math.max(streak,count);
            }            
        }
        
        return count;
    }
}