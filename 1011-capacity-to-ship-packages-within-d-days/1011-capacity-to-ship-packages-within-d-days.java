class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max =0;
        for(int i :weights){
            sum+=i;
            max =Math.max(i,max);
        }
        int ans = Integer.MAX_VALUE;
        int lo=max;
        int high=sum;
        while(lo<=high){
            int mid =lo +(high-lo)/2;
            sum=0;
            int d=1;
            for(int i=0; i<weights.length; i++){
                sum +=weights[i];
                if(sum>mid){
                    sum=weights[i];
                        d++;
                }
            }
            if(days >= d){
                ans =Math.min(ans,mid);
                high =mid-1;
            }else{
                lo =mid+1;
            }
        }
        return ans;
    }
}