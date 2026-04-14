class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int right =0;
        int maxLen =0;
        int count =0;

        while(right < nums.length){
            if(nums[right] ==0){
                count++;
            }
            while(count >k){
                count -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}