class Solution {
    public boolean search(int[] nums, int target) {
        int l =0, r =nums.length-1;
        
        while(l<=r){
            int mid =l +(r-l)/2;
            if(nums[mid]==target)return true;
            else if(nums[l] < nums[mid]){
                
                if(nums[mid] >target && target >=nums[l]){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }else if(nums[l] >nums[mid]){
                if(target >nums[mid] && target <= nums[r]){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }else{
                l++;
            }
        }
        return false;
    }
}