class Solution {
    public int[] searchRange(int[] nums, int target) {
            int start = helper(nums,target,true);
            if(start ==-1){
                return new int[]{-1,-1};
            }
            int end =helper(nums,target,false);
         return new int[]{start,end};   
    }
    
    public int helper(int[] nums, int target, boolean flag){
        int left =0, right =nums.length-1;
        
        while(left <=right){
            int mid = left+ (right-left)/2;
            if(nums[mid] ==target){
                if(flag){
                    if(mid == left || nums[mid-1] !=nums[mid]){
                            return mid;
                    }
                   right =mid-1;

                }else{
                    if(mid ==right || nums[mid+1] !=nums[mid]){
                            return mid;
                    }
                    left =mid+1;
                }
            }else{
                if(nums[mid]> target){
                    right =mid-1;
                }else{
                    left =mid +1;
                }
            }
        }
        
        return -1;
    }
}