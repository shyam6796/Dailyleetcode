class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxFreq =0;
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();

       for(int i =0; i < nums.length; i++){
            if(!first.containsKey(nums[i])) first.put(nums[i],i);
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
            if(maxFreq < map.get(nums[i])){
                maxFreq=map.get(nums[i]);
                ans = i-first.get(nums[i])+1;
                
            }else if(maxFreq ==map.get(nums[i])){
                 ans = Math.min(ans,i-first.get(nums[i])+1);
            }
       }

        
        
        return ans;
    }
}