class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int prd=1;
        for(int i=0;  i<nums.length; i++){
            prd *=nums[i];
            ans= Math.max(prd,ans);
            if(prd==0){
                prd=1;
            }
        }
        prd=1;
        for(int i=nums.length-1; i>=0; i--){
            prd *=nums[i];
            ans= Math.max(prd,ans);
            if(prd==0){
                prd=1;
            }
        }
       return ans; 
    }
}