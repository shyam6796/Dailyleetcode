class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int i =0;
         int j= 0;
        double ans =0, sum =0;       
         
        while(i < nums.length){
            if(i < k){
                sum +=nums[i];
                i++;
                if(i==k)ans =sum/k;
            }else{
                sum +=nums[i]-nums[j];
                i++;
                j++;
                ans =Math.max(ans,sum/k);
            }
            
        }
        return ans;
    }
}