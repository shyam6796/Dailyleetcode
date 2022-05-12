class TicTacToe {
    int rows[];
    int cols[];
    int diag=0;
    int antiDiag=0;
    int n;
    public TicTacToe(int n) {
        this.n=n;
        rows =new int[n];
        cols=new int[n];
    }
    
    public int move(int row, int col, int player) {
        int p = player ==1 ? 1 :-1;
        
        rows[row] +=p;
        cols[col] +=p;
        if(row==col)diag +=p;
        if(row== (n-col-1))antiDiag +=p;
        
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diag) == n ||
                Math.abs(antiDiag) == n) {
            return player;
        }
                                 
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */