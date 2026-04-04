class Solution {
    public int minOperations(int n) {
       if(n==0)return 0;
       if(n==1)return 1;

       int val =1;
       while(val *2 < n){
            val =2*val;
       }
       return 1 + Math.min(minOperations(2*val -n),minOperations(n-val));
    }
}