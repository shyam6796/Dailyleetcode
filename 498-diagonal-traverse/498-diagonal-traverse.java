class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int rows =mat.length;
        int cols =mat[0].length;
        int ans[] = new int[cols*rows];
        int indx =0;
        int x=0;
        int y=0;
        while(indx<ans.length){
            ans[indx++] =mat[x][y];
            int sum =x+y;
            if(sum%2 ==0){
                if(x>0 && y<cols-1){
                    x--;
                    y++;
                }else if(y<cols-1){
                    y++;
                }else{
                    x++;
                }                
            }else{
                if(y>0 && x<rows-1){
                    x++;
                    y--;
                }else if(x<rows-1){
                    x++;
                }else{
                    y++;
                }         
                
            }
        }
        return ans;
    }
}