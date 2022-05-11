class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSelect(nums,nums.length-k,0,nums.length-1);
    }
    public int quickSelect(int[] nums, int k, int left, int right){
        if(left==right) return nums[left];
        
        
        int pivot =partition(nums,left,right);
        if(pivot ==k)return nums[k];
        else if(pivot >k){
            return quickSelect(nums,k,left,pivot-1);
        }
        return quickSelect(nums,k,pivot+1,right);
    }
    
    public int partition(int[] nums,int left, int right){
        Random random_num = new Random();
        int pivot_index=left + random_num.nextInt(right - left);
        int pivot =nums[pivot_index];
        int store_index=left;
        swap(nums,right,pivot_index);
        for(int i =left; i<=right; i++){
            if(pivot >nums[i]){
                swap(nums,store_index,i);
                store_index++;
            }
        }
        swap(nums,store_index,right);
        return store_index;
    }
    
    public void swap(int[] nums,int i, int j){
        int temp =nums[j];
        nums[j]= nums[i];
        nums[i]=temp;
    }
}