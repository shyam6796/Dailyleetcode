class Solution {
    public int findKthLargest(int[] nums, int k) {
       return quickSelection(nums,nums.length-k,0,nums.length-1);
    }
    
    public int quickSelection(int[] nums, int k, int left, int right){
        if(left ==right)return nums[left];
        
         Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left); 
        
        pivot_index =partiton(nums,left,right,pivot_index);
        
        if(k==pivot_index)return nums[k];
        else if(k<pivot_index){
            
            return  quickSelection(nums,k,left,pivot_index-1);
           
        }
         return  quickSelection(nums,k,pivot_index+1,right);
    }
    
    public int partiton(int nums[], int left, int right, int pivot_index){
        int pivot =nums[pivot_index];
        int store_index=left;
        swap(nums,right,pivot_index);
        
        for(int i=left; i<=right; i++){
            if(nums[i]<pivot){
                swap(nums,store_index,i);
                store_index++;
            }
        }
        swap(nums,store_index,right);
        return store_index;
    
    }
    
    public void swap(int nums[], int i, int j){
        int temp =nums[i];
        nums[i] =nums[j];
        nums[j]=temp;
    }
}