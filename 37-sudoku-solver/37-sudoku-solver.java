class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    public boolean helper(char[][] board){
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] =='.'){
                    for(int k=1; k<=9; k++){
                        if(isValid(board,k,i,j)){
                            board[i][j] =(char)(k+'0');
                            if(helper(board)) return true;
                            else{
                                 board[i][j] ='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board,int num, int row, int col){
        boolean flag1 =true, flag2=true, flag3 =true;
        for(int i=0; i<9; i++){
            if(board[row][i] !='.'  && board[row][i] -'0'==num)flag1 = false;
            if(board[i][col] !='.'  && board[i][col] -'0'==num)flag2 = false;
        }
        int boxRow = row -row%3;
        int boxCol =col -col%3;
        
        for(int i=boxRow; i<boxRow+3; i++){
            for(int j=boxCol; j<boxCol+3; j++){
                if(board[i][j] !='.'  && board[i][j] -'0'==num)flag3 = false;
            }
        }
        
        return flag1 && flag2 && flag3;
    }
}