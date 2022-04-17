class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n==0)return 1;
        if(n<0){
            N=-N;
            x=1/x;
        }
        double ans=1;
        double currentProduct =x;
        
        for(long i=N; i>0; i=i/2){
            if(i%2 ==1){
                ans= ans*currentProduct;
            }
            currentProduct=currentProduct * currentProduct;
        }
        return ans;
    }
}