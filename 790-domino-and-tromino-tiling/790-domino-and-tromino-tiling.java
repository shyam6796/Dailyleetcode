class Solution {
    public int numTilings(int n) {
       if(n < 3){
            return n;
        }
        
        int ans[] = new int[n+1];
        ans[0]=0;
        ans[1]=1;
        ans[2]=2;
        ans[3]=5;
        
        for(int i=4; i<=n; i++){
            ans[i] =(2 * ans[i-1] %1000000007 +ans[i-3] % 1000000007)%1000000007;
        }
        return ans[n];
    }
    
}