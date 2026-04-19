class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        
        for(int k = 1; k *(k-1) < 2*N;  k++){
                int numerator = N -(k * (k-1) /2);
                if(numerator %k ==0)ans++;
        }
        return ans;
    }
}