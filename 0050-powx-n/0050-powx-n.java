class Solution {
    public double myPow(double x, int n) {
        double N =n;
        if(n<0){
            N= -1 * N;
            x =1/x;
        }
        double ans =1;

        while(N !=0){
            if(N%2==0){
                x =x*x;
                N /=2;
            }else{
                N--;
                ans =ans*x;
            }
        }
        return ans;

    }
}