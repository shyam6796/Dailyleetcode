class Solution {
    
       public int numberOfWeakCharacters(int[][] a) {
        Arrays.sort(a, (b,c) -> (b[0]==c[0]) ? c[1] - b[1]  : b[0]-c[0] );
        int n = a.length,  max  = a[n-1][1] , count=0;
        for(int i = n - 2; i>=0 ; i--)
        {
            if(a[i][1]<max) count++;
            max = Math.max(max,a[i][1]);
        }
       return count; 
     
    }
}