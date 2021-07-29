class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length;
        int ans[] = new int[j];
        for(int k :nums){
            if(k%2==0){
                ans[i]=k;
                i++;
            }else{
                ans[j-1]=k;
                j--;
            }
        }
        return ans;
    }
}