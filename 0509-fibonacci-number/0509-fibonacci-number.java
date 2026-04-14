class Solution {
    public int fib(int n) {
        if(n <2)return n;
        int a =1;
        int b= 1;
        
        for(int i=2; i <n; i++){
            int temp =a;
            a = a+b;
            b=temp;
        }
        return a;
    }
}