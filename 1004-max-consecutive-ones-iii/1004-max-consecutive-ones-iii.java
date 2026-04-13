class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = 0;
        int left =0;
        int count = 0;
        int right = 0;

        while(right < nums.length){
            if(nums[right]==0){
                count++;
            }
            while(count >k){
                if(nums[left] ==0)count--;
                left++;
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}