class Solution {
    public int maxProduct(int[] nums) {
        int max =nums[0];
        int min =nums[0];
        int ans =nums[0];

        for(int i=1; i < nums.length; i++){
            int temp =min;
            min = Math.min(nums[i], Math.min(nums[i]*max,min*nums[i]));
            max = Math.max(nums[i], Math.max(nums[i]*temp,nums[i]*max));
            ans=Math.max(ans,max);
        }   
        return ans;
    }
}