class TicTacToe {
    int matrix[][];
    int size;
    public TicTacToe(int n) {
      matrix= new int[n][n];
        size =n;
    }
    
    public int move(int row, int col, int player) {
        matrix[row][col]=player;
        
        if(checkRow(row,player) ||checkCol(col,player) || (col ==row && checkDiag(player)) || (col == size-row-1 && checkAntiDiag(player))){
            return player;
        }
        return 0;
    }
    
    public boolean checkRow(int row, int player){
        for(int i=0; i<size; i++){
            if(matrix[row][i] != player)return false;
        }
        return true;
    } 
    
    public boolean checkCol(int col, int player){
        for(int i=0; i<size; i++){
            if(matrix[i][col] != player)return false;
        }
        return true;
    }     
    
    public boolean checkDiag(int player){
        for(int i=0; i<size; i++){
            if(matrix[i][i] != player)return false;
        }
        return true;
    } 
    
    public boolean checkAntiDiag(int player){
        for(int i=0; i<size; i++){
            if(matrix[i][size -i -1] != player)return false;
        }
        return true;
    } 
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */