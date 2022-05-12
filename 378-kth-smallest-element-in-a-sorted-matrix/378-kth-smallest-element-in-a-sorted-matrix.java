class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo =matrix[0][0], hi =matrix[matrix.length-1][matrix.length-1];
        while(lo<hi){
            int mid =lo+(hi-lo)/2;
            int count =lessOrEqual(matrix,mid);
            if(count>=k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    
    }
    
    public int lessOrEqual(int [][] matrix, int mid){
        int i=matrix.length-1, j=0;
         int cnt = 0;
        while(i>=0 && j<matrix[0].length){
             if (matrix[i][j] > mid)
                i--;
            else{
                cnt +=i+1;
                j++;
            }
        }
        return cnt;
        
    
    }
}