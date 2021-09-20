class Solution {
  public boolean exist(char[][] board, String word) {
    for(int r = 0; r < board.length; r++) {
        for(int c = 0; c < board[r].length; c++) {  
            if(board[r][c] == word.charAt(0) && dfs(board, r, c, word, 0)) {
                return true;
            }
        }
    }
    return false; 
}

/*
    Input: char[][] board, int row, int col, String word, int index
    
    ALGORITHM
        BASE CASE: if index equals the words length
                   -> return true
        BASE CASE: if the row is out of the grid, the col is out of the grid, 
				   or the character at row,col does not equal the character in word at index
                    -> return false
        
        STEP 1: store the current char
        STEP 2: set the current char to ""
        STEP 3: call function in all four valid directions
        STEP 4: set the current char back
        STEP 5: return OR of all four calls
*/
public boolean dfs(char[][] grid, int row, int col, String word, int index){

    if(index == word.length()) {
        return true;
    }
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length 
        || grid[row][col] != word.charAt(index)) {
        return false;
    }
    
    char current = word.charAt(index);
    grid[row][col] = ' ';
    
    boolean result = 
                    dfs(grid,row+1,col,word,index+1) 
					|| dfs(grid,row,col+1,word,index+1) 
					||  dfs(grid,row-1,col,word,index+1) 
					|| dfs(grid,row,col-1,word,index+1);

    grid[row][col] = current;
    return result;
    }
}