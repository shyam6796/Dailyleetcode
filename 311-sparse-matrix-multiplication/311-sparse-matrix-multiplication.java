class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        int k = mat1[0].length;
        
        
        int [][] ans = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<k; j++){
                if(mat1[i][j] !=0){
                    for(int l=0; l<n; l++){
                        ans[i][l] += mat1[i][j] *mat2[j][l];
                    }
                }
            }
        }
        return ans;
    }
}