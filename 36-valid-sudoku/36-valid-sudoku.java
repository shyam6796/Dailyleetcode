class Solution {
    public boolean isValidSudoku(char[][] board) {
             HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int r = 0; r < 9; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }
            for(int i =0; i<9; i++){
                for(int j=0; j<9; j++){
                    char val = board[i][j];
                    if(val == '.')continue;
                    
                    if(rows[i].contains(val)){
                        return false;
                    }
                    rows[i].add(val);
                    
                    if(cols[j].contains(val)){
                        return false;
                    }
                    cols[j].add(val);
                    
                    int indx =(i/3) *3 +j/3;
                    
                    if(boxes[indx].contains(val)){
                        return false;
                    }
                    boxes[indx].add(val);
                    
                    
                    }
                
            }
        return true;
    }
}