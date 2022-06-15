class Solution {
    public int countOrders(int n) {
        if(n<2)return 1;
        long dp[] =new long[n+1];
        dp[1]=1L;
        dp[2]=6L;
        long mod = 1000_000_007;
        for(int i=3; i<=n; i++){
            long place =2*i-1;
            long perm = place*(place+1)/2;
            dp[i]= (dp[i-1]*perm)%mod;
        }
        return (int)dp[n];
    }
}