class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] col =new HashSet[9];
         Set<Integer>[] row =new HashSet[9];
         Set<Integer>[] boxs =new HashSet[9];
       
        for(int i=0; i<9; i++){
            col[i]=(new HashSet<>());
            row[i]=(new HashSet<>());
            boxs[i]=(new HashSet<>());
            }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] =='.')continue;
                 if(col[i].contains(board[i][j] -'0')){
                    return false;
                }else{
                     col[i].add(board[i][j] -'0');
                 }
                if(row[j].contains(board[i][j] -'0')){
                    return false;
                }else{
                     row[j].add(board[i][j] -'0');
                 }
                int box = (i/3)*3 +j/3;
                if(boxs[box].contains(board[i][j] -'0')){
                    return false;
                }else{
                     boxs[box].add(board[i][j] -'0');
                 }
            }
        }
        
        return true;
    }
}