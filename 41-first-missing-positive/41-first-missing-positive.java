class Solution {
    public int firstMissingPositive(int[] nums) {
        int n =nums.length;
        
        // swap the numbers to the correct indexes eg 2 should be present at index 1 as indexes start from 0;
        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n){
                int pos = nums[i]-1;
                if(nums[pos]!=nums[i]){
                    swap(nums,pos,i);
                    i--;
                }
            }
        }
        
        // find the missing value
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1) return (i+1);
        }
        return n+1; // if all the nums are positive and present then the answer is n+1;
    }
    
    public static void swap(int[] nums,int pos, int i){
        int temp = nums[pos];
        nums[pos] = nums[i];
        nums[i] = temp;
    }
}