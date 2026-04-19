class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        
        for(int k = 1; k *(k-1) < 2*N;  k++){
                int numerator = N -(k * (k-1) /2);
                if(numerator %k ==0)ans++;
        }
        return ans;
    }
    /*k = no of elemnt 
    k =1 =15
    k= 2 = 15 =8+7
    k =3  = 15 = 4 +5 =6;
    ....

        x  +x+1+ x+2 .... .x+k-1 = N
        x +x +x ... k times   + (1 + 2 +3 .... k-1) = N;
        kx + (k *(k-1)/2) =N;
        x = N - (k * (k-1) /2 )/k;
        x > 0
        N- (k * (k-1)/2) > 0
        2N  > k(k-1);

        
    */
}