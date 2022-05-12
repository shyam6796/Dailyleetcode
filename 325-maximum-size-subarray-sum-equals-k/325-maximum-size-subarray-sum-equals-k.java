class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map =new HashMap<>();
        int sum=0;
        int ans=0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];
            if(sum==k)ans= i+1;
            if(map.containsKey(sum-k)) ans =Math.max(i-map.get(sum-k),ans);
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        
        return ans;
    }
}