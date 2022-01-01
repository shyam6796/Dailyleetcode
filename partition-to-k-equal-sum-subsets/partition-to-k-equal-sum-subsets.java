class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        for(int i :nums){
           sum +=i; 
        }
        
        if(sum %k !=0)return false;
        Arrays.sort(nums);
        sum =sum/k;
        if(sum <nums[nums.length-1])return false;
        boolean[] arr =new boolean[nums.length];
        return helper(nums,k,sum,arr,0,0,0);
    }
    
    public boolean helper(int []nums, int targetSet, int targetSum, boolean [] arr, int idx, int currentSum, int curentSet){
        if(curentSet == targetSet){
              return true;              
        }
        
        for(int i=idx; i<nums.length; i++){
            
            if(arr[i] || (i<nums.length-1 && nums[i]==nums[i+1] && arr[i+1]==true)){
                continue;
            }
            
            int sum = currentSum +nums[i];
            if(sum > targetSum)break;
            
            arr[i] =true;
            if(sum== targetSum && helper(nums,targetSet,targetSum,arr,0,0,curentSet+1)){
                return true;
            }else if(helper(nums,targetSet,targetSum,arr,idx+1,sum,curentSet)){
                return true;
            }
             arr[i] =false;
            
        }
        return false;
    }
}