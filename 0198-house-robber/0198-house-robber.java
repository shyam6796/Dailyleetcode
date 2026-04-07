class Solution {
    Integer memo[];
    public int rob(int[] nums) {
        memo =new Integer[nums.length+1];
        return helper(nums,0);
    }
    public int helper(int [] nums, int i){
        if(i >= nums.length)return 0;
        
        if(memo[i] !=null)return memo[i];

        int take = helper(nums, i+2) + nums[i];
        int skip =helper(nums, i+1);

        return memo[i] = Math.max(take, skip);
    }
}