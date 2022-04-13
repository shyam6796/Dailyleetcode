class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
           N=-N;
        }
       double ans = 1;
       double currProduct =x; 
        for(long i = N; i > 0; i = i/2){
            if(i%2==1){
                ans =ans*currProduct;
            }
                currProduct =currProduct*currProduct;
        }
        return ans;
    }
}