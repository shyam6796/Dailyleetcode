class Solution {
    public int numTilings(int n) {
       if(n < 3){
            return n;
        }

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        
        for(int i = 4;i<=n;i++){
            arr[i] = ((2 * arr[i-1])%1000000007 + arr[i-3]%1000000007)%1000000007;
        }
        return arr[n];
    }
    
}