class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int left=0, right, k=1;
        for(right=0; right<nums.length; right++){
            if(nums[right]==0){
                k--;
            }
            
            if(k<0){
                k +=1-nums[left];
                left++;
            }
        }
        return right-left;
    }
}