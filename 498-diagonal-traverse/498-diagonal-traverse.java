class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m =mat.length;
        int n =mat[0].length;
        int ans [] =new int[m*n];
        int i=0, j=0, index=0;
        while(index <ans.length){
            ans[index++]=mat[i][j];
            
            if((i+j) %2 ==0){
                if(i>0 && j<n-1){
                    i--;
                    j++;
                }else if(j<n-1){
                    j++;
                }else{
                    i++;
                }                    
            }else{
                if(j>0 && i<m-1){
                    j--;
                    i++;
                }else if(i<m-1){
                    i++;
                }else{
                    j++;
                }    
            }
        }
        
        return ans;
    }
}