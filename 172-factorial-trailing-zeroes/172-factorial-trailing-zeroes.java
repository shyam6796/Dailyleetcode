class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        int base = 5;
        
        while(base<=n){
            cnt+=n/base;
            base*=5;
        }
        return cnt;
    }
}
    