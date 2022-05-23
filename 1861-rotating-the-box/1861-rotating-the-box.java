class Solution {
    public final char STONE = '#';
    public final char OBSTACLE = '*';
    public final char EMPTY = '.';
    
    public char[][] rotateTheBox(char[][] box) {
        applyGravity(box);
        return rotate(box);
    }
    public void applyGravity(char [][] box){
        
        for (char[] row : box) {
            //we start by assuming that the last cell is empty
            int emptyPos = row.length - 1;

            //process the the row from the end 
            for (int col = row.length - 1; col >= 0; col--) {
                //if stone:
                //  1) set current cell to empty
                //  2) set empty position to stone 
                //  3) update empty position 
                if (row[col] == STONE) {
                    row[col] = EMPTY;
                    row[emptyPos--] = STONE;
                } 
                
                //if obstacle --> we update our next empty pos to jump from the obstacle to the next cell
                else if (row[col] == OBSTACLE) {
                    emptyPos = col - 1;
                }
            }
        }
    }
    
    public char[][] rotate(char[][]box){
        int rowLen = box.length;
        int colLen = box[0].length;
        char[][] newBox = new char[colLen][rowLen];
        
         for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                //to get the mirror cell, we use (rowLen - 1 - row)
                newBox[col][rowLen - 1 - row] = box[row][col];
            }
        }

        return newBox;
    } 
}