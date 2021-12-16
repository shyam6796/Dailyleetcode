class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
           for(int i=0; i<nums.length; i++){
               nums[i] =nums[i] * nums[i] * a + nums[i] * b + c;
           }
        int [] ans = new int[nums.length];
        
        if(a>=0){
            int index = nums.length-1;
            int i=0, j= index;
            while(index>=0){
                if(nums[i] >=nums[j]){
                    ans[index--] = nums[i++];
                }else{
                    ans[index--] = nums[j--];
                } 
            }
        }else{
            int index = 0;
            int i=0, j = nums.length-1;
            while(index<=nums.length-1){
                if(nums[i] >= nums[j]){
                    ans[index++] = nums[j--];
                }else{
                    ans[index++] = nums[i++];
                } 
            }
        }
         return ans;   
    }
}   