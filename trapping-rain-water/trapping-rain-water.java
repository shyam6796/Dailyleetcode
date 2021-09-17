class Solution {
    public int trap(int[] height) {
        int maxL=height[0];
        int maxR=height[height.length-1];
        int i=0,ans=0;
        int j=height.length-1;
        while(i<j){
            if(maxL <maxR){
                 i++;
                maxL=Math.max(maxL,height[i]);
                ans += maxL-height[i];
            }else{
                j--;
                maxR=Math.max(maxR,height[j]);
                ans +=maxR-height[j];
            }
        }
        return ans;
    }
}