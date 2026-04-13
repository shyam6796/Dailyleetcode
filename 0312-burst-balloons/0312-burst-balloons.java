class Solution {
    Integer memo[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return helper(nums,0,nums.length-1);
    }

    public int helper(int nums[], int left, int right){
        if(left >right)return 0;

        if(memo[left][right] !=null)return memo[left][right];
        int ans =0;

        for(int i=left; i<=right; i++){
            int prev =helper(nums, left, i-1);
            int next =helper(nums, i+1, right);
            int curr = (left==0 ? 1 : nums[left-1] ) * nums[i] * (right==nums.length-1 ? 1 : nums[right+1]);
            ans =Math.max(ans, prev +next +curr); 
        }
        return memo[left][right] =ans;
    }
}