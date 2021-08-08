class Solution {
    public int shipWithinDays(int[] weights, int days) {
          int sum = 0;
        int max = Integer.MIN_VALUE; 
        for(int i : weights)
        {
            sum += i; 
            max = Math.max(max , i); 
        }
        int lo = max; 
        int hi = sum; 
        int ans = Integer.MAX_VALUE; 
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2; 
            int psum = 0; 
            int count = 1; 
            for(int i = 0 ; i < weights.length ; i++)
            {
                psum += weights[i]; 
                if(psum > mid)
                {
                    psum = weights[i]; 
                    count++;
                }
            }
            if(count <= days) 
            {
                ans = Math.min(ans , mid); 
                hi = mid - 1; 
            }    
            else{
                lo = mid + 1; 
            }
        }
        return ans; 
        
    }
}