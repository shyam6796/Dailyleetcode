class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        for(int i : nums){
            sum +=i;
        }
        if(sum %k !=0)return false;
        
        int target =sum /k;
        Arrays.sort(nums);
        if(target < nums[nums.length-1]) return false;
        
        boolean arr[] = new boolean[nums.length];
        
        return dfs(arr,nums,target,k,0,0,0);
        
    }
    
    
    public boolean dfs(boolean[] arr, int[] nums, int target,int targetSet, int idx, int currentSum, int currentSet){
        if(currentSet== targetSet) return true;
        
        for(int i=idx; i<nums.length; i++){
            
            if(arr[i] || (i <nums.length -1 && (nums[i] ==nums[i+1]) && arr[i+1]==true)){
                continue;
            }
        
            int sum = currentSum + nums[i];
            if(sum > target)break;
            
            arr[i] =true;
            if(sum ==target && dfs(arr,nums,target,targetSet,0,0, currentSet+1)){
                return true;
            }else if(dfs(arr,nums,target,targetSet,idx+1, sum, currentSet)){
                return true;
            }
             arr[i] =false;
        }
        
        return false;
    }
}