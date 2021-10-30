class Solution {
     List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
      
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        backtrack(0,n, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return ans;
    }
    
    public void backtrack(int row, int n, HashSet<Integer> cols, HashSet<Integer> diag, HashSet<Integer> antiDiag, char[][] board){
        
        if(row ==n){
                List<String> list = new ArrayList<>();
                for(int i=0; i<n; i++){
                    String value =new String(board[i]);
                    list.add(value);
                }
                ans.add(list);
        }
        
        for(int col =0; col<n; col++){
            int currDiag = row -col;
            int currAntiDiag = row +col;
            
            if(cols.contains(col) || diag.contains(currDiag) || antiDiag.contains(currAntiDiag)) continue;
            
            cols.add(col);
            diag.add(currDiag);
            antiDiag.add(currAntiDiag);
            board[row][col] = 'Q';
            backtrack(row+1,n, cols, diag, antiDiag, board);
            
            cols.remove(col);
            diag.remove(currDiag);
            antiDiag.remove(currAntiDiag);
            board[row][col] = '.';
        }
    }
}