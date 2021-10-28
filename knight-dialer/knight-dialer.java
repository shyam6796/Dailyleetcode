class Solution {
   int MOD = 1000000007;
    public int knightDialer(int N) {
        long dp[] = new long[10];
        Arrays.fill(dp , 1);
        long ans = 0;
        for(int i = 1 ; i < N ; i++) {
            long temp[] = new long[10];
            temp[0] = (dp[4]+dp[6]) % MOD;
            temp[1] = (dp[6]+dp[8]) % MOD;
            temp[2] = (dp[7]+dp[9]) % MOD;
            temp[3] = (dp[4]+dp[8]) % MOD;
            temp[4] = (((dp[0]+dp[3]) % MOD)+dp[9])%MOD;
            temp[6] = (((dp[0]+dp[1]) % MOD)+dp[7])%MOD;
            temp[7] = (dp[2]+dp[6])%MOD;
            temp[8] = (dp[1]+dp[3])%MOD;
            temp[9] = (dp[4]+dp[2])%MOD;
            dp = temp;
        }
        for(long val : dp) 
            ans = (ans + val) % MOD;
        return (int) ans;
    }
}