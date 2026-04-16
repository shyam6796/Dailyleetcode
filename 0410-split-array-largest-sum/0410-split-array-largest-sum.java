class Solution {
    public int splitArray(int[] nums, int k) {
        int left =0;
        int right =0;
        for(int i :nums){
            left = Math.max(left,i);
            right +=i;
        }

        int ans = right;

        while(left <=right){
            int mid = left +(right -left)/2;

            if(helper(nums,k,mid)){
                ans =mid;
                right =mid-1;
            }else{
                left =mid+1;
            }
        }
        return ans;
    }

    public boolean helper(int nums[], int k, int target){
        int subarray =1;
         int sum =0;
        for(int i =0; i < nums.length; i++){
            if(sum +nums[i] > target){
                subarray++;
                sum = nums[i];
            }else{
                sum +=nums[i];
            }
            if(subarray >k)return false;
        }
        return subarray <=k;
    }
}