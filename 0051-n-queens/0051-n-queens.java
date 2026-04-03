class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char [][] board = new char[n][n];
        for(char arr[] : board){
            Arrays.fill(arr, '.');
        }
        helper(board,list ,n ,0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return list;
    }

    public void helper(char board[][], List<List<String>> list, int n, int row, Set<Integer> cols ,Set<Integer> diag, Set<Integer> antiDiag){
        if(row ==n){
            List<String> ans = new ArrayList<>();
            for(char [] arr : board){
                ans.add(new String(arr));
            }
            list.add(ans);
            return;
        }

        for(int col =0; col <n; col++){
            int x =row +col;
            int y =row -col;

            if(cols.contains(col) || diag.contains(y) || antiDiag.contains(x))continue;
            board[row][col]='Q';
            cols.add(col);
            diag.add(y);
            antiDiag.add(x);
            helper(board, list, n, row+1, cols, diag, antiDiag);
            cols.remove(col);
            diag.remove(y);
            antiDiag.remove(x);
            board[row][col] ='.';

        }
    }
}