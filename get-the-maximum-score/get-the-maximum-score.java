class Solution {
    public int maxSum(int[] A, int[] B) {
        int i=0, j=0, m=A.length, n=B.length;
        long res =0;
        long s1=0,s2=0;
        while(i<m && j<n){
            if(A[i] <B[j]){
                s1+=A[i];
                i++;
            }else if(B[j] <A[i]){
                s2 +=B[j];
                    j++;
            }else{
                res+= Math.max(s1,s2) +A[i];
                i++;
                j++;
                s1=0;
                s2=0;
            }
        }
        
        while(i<m){
            s1+=A[i];
                i++;
        }
        while(j<n){
            s2+=B[j];
                j++;
        }
        return (int)((Math.max(s1,s2)+res)%1000000007L);
        
    }
}