class Solution {
    int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0];
            int y = click[1];
            if(board[x][y]=='M'){
                board[x][y] ='X';
                return board;
            }
            DFS(board,x,y);
            return board;
    }

    public void DFS(char [][] board, int x, int y){
        if(x <0 || y <0 || x >=board.length || y >=board[0].length || board[x][y] !='E' )return ;
        int num = getNum(board,x,y);

        if(num==0){
            board[x][y] ='B';
            for(int dir[] : dirs){
                int i = x + dir[0];
                int j = y + dir[1];
                DFS(board, i, j);
            }

        }else{
            board[x][y] =(char)('0' +num);
        }
    }

    public int getNum (char [][] board, int x ,int y){
        int num =0;
        for(int []dir : dirs){
            int i =x +dir[0];
            int j =y +dir[1];
            if(i < 0|| j <0 || i >=board.length || j >= board[0].length)continue;
            if(board[i][j]=='M' || board[i][j] =='X')num++;
        }
        return num;
    }
}