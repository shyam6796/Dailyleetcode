class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList<Integer> list = new LinkedList<>();
       
         int result [] = new int [nums.length-k+1];
        int j=0;
        for(int i=0; i<nums.length; i++){
            
            while(!list.isEmpty() && list.getFirst() <=i-k){
                list.removeFirst();
            }
            while(!list.isEmpty() && nums[i] >= nums[list.getLast()]){
                 list.removeLast();
            }
            list.addLast(i);
            if(i >=k-1){
                result[j] = nums[list.getFirst()];
                j++;
            }
            
        
        }
     
        
        return result;
    }
}