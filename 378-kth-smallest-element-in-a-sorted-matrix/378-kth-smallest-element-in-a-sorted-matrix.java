class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while(lo<hi){
            int mid =lo+(hi-lo)/2;
            int count= lessOrEqual(matrix,mid);
            if(count<k){
                lo =mid+1;
            }else{
                 hi = mid;
            }
        }
        return lo;
    }
    
    public int lessOrEqual(int[][] matrix, int k){
        int i=matrix.length-1, j=0;
         int cnt = 0;
        while(i>=0 && j<matrix[0].length){
             if (matrix[i][j] > k)
                i--;
            else{
                cnt +=i+1;
                j++;
            }
        }
        return cnt;
    }
}