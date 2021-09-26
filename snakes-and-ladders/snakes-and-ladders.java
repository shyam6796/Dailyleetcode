class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        
        int cell=1;
        boolean flag=true;
        int n =board.length;
        for(int i=n-1; i>=0; i--){
            if(flag){
                for(int j=0; j<n; j++){
                    if(board[i][j]!=-1){
                        map.put(cell,board[i][j]);
                    }
                    cell++;
                }
                flag=false;
            }
            else{
               for(int j=n-1; j>=0; j--){
                    if(board[i][j]!=-1){
                        map.put(cell,board[i][j]);
                    }
                    cell++;
                }
                flag=true; 
            }
        }
        
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        cell=1;
        queue.offer(cell);
        int moves =0;
        
        while(!queue.isEmpty()){
            
            int size =queue.size();
            for(int i=0; i<size; i++){
                cell =queue.remove();
                if(cell==board.length*board.length) return moves;
                if(visited.contains(cell)) continue;
                 visited.add(cell); 
                
                for(int j=1; j<=6; j++){
                   int nextCell = cell+j;
                    int actualCell = map.getOrDefault(nextCell,nextCell);
                    if(!visited.contains(actualCell) && actualCell <=(n*n)){
                        queue.add(actualCell);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}