class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=matrix.length-1; i>=0; i--){
             if(matrix[i][0] >target)continue;
            for(int j=0; j<matrix[i].length; j++){
               if(matrix[i][j]==target) return true;
            }
                
        }
        return false;
    }
}