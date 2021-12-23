class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int temp=0;
        
        for(int i=0; i<nums.length; i++){
            temp += nums[i];
            sum = Math.max(sum,temp);
            temp = Math.max(0,temp);
        }
        return sum;
    }
}