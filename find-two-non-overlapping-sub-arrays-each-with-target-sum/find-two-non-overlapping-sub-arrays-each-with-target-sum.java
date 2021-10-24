class Solution {
    public int minSumOfLengths(int[] a, int target) {
            int n =a.length;
            int min[] =new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        int res=Integer.MAX_VALUE, sum=0, m =Integer.MAX_VALUE;
        
        for(int i=n-1, j=n-1; i>=0; i--){
            sum +=a[i];
            while(sum>target){
                sum -=a[j--];
            }
            if(sum == target){
                int len= j-i+1;
                if(i+len <n && min[i+len] != Integer.MAX_VALUE){
                    res =Math.min(res,min[i+len]+ len);
                }
                m=Math.min(m,len);
                sum -= a[j--];  
            }
            min[i]=m;
        }
        return  res ==Integer.MAX_VALUE ? -1 : res;
    }
}