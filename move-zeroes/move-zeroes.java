class Solution {
    public void moveZeroes(int[] nums) {
        int count =0, j=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                nums[j++] =nums[i];
            }else{
                count++;
            }
        }
        Arrays.fill(nums,nums.length-count, nums.length,0);
    }
}