class Solution {
    public boolean validTicTacToe(String[] board) {
        int x =0;
        int o =0;
        for(int i=0; i <board.length; i++){
            String s = board[i];
            for(int j =0; j < s.length(); j++){
                if(s.charAt(j)=='O')o++;
                else if(s.charAt(j)=='X')x++;
            }
        }
        if(o !=x && o !=x-1)return false;
        if(win(board,'X') && o !=x-1)return false;
         if(win(board,'O') && o !=x)return false;
         return true;
    }
    
    public boolean win(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }
}