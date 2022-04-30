class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int [] ans =new int[m*n];
        int index=0;
        int x=0,y=0;
        while(index <ans.length){
            ans[index++] =mat[x][y];
            if((x+y)%2 == 0){
                if(x>0 && y<n-1){
                    x--;
                    y++;
                }else if(y<n-1){
                    y++;
                }else{
                    x++;
                }
            }else{
                if(y>0 && x<m-1){
                    y--;
                    x++;
                }else if(x<m-1){
                    x++;
                }else{
                    y++;
                }
            }
        }
        
        return ans;
    }
}