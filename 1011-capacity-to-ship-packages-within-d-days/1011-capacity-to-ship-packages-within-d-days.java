class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i :weights){
            sum +=i;
            max=Math.max(i,max);
        }
        int ans =Integer.MAX_VALUE;
        int lo=max, hi=sum;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            sum =0;
            int day =1;
            
            for(int i=0; i<weights.length; i++){
                sum +=weights[i];
                if(sum >mid){
                    sum =weights[i];
                    day++;
                }
                
            }
        
            if(days >= day){
                ans =Math.min(ans,mid);
               hi =mid-1;
            }else{
                lo =mid+1;
            }
            
        }
        return ans;
    }
}