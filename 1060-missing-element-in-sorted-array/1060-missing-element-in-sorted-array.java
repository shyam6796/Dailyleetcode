class Solution {
    public int missingElement(int[] nums, int k) {
        int left =0;
        int right =nums.length-1;
        int ref=nums[0];
        
        while(left<=right){
            int mid =left +(right-left)/2;
            if(nums[mid] -(ref+mid) >=k){
                right =mid-1;
            }else{
                left =mid+1;
            }
        }
        
        return ref+right+k;
    }
}