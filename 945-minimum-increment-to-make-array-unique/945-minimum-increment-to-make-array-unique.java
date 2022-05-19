class Solution {
    public int minIncrementForUnique(int[] nums) {
          Arrays.sort(nums);
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            int val = nums[i];
            while(val <= nums[i-1]){
                count++;
                val++;
            }
            nums[i] = val;
        }
         return count;   
    }
}