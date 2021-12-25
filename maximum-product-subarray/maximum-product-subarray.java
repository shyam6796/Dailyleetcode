class Solution {
    public int maxProduct(int[] nums) {
        int max =Integer.MIN_VALUE;
        int prod1 =1, prod2 = 1;
        
        for(int i=0; i<nums.length; i++){
            prod1 *= nums[i];
            prod2 *= nums[nums.length-i-1];
            
            max =Math.max(max, Math.max(prod1,prod2));
            if(prod1==0)prod1 =1;
            if(prod2 == 0)prod2 =1;
        }
        
        return max;
    }
}