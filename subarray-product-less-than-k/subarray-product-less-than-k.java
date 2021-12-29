class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int pord =1;
        int left =0, right=0;
        int results=0;
        while(right<nums.length){
            pord *= nums[right];
            
            while(pord >=k){
                pord /= nums[left++];
            }
            
            results += right-left +1;
            
            
            
            right++;
        }
        
        return results;
    }
}