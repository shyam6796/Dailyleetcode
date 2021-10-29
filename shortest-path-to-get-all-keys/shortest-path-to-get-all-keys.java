class Solution {
    public int shortestPathAllKeys(String[] grid) {
            int m =grid.length;
            int n =grid[0].length();
            int count=0;
            Queue<int[]> queue = new LinkedList<>();
            int directions  [][] = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    char ch =grid[i].charAt(j);
                    if(ch == '@'){
                        queue.add(new int[]{i,j,0,0});
                    }else if(ch >= 'a' && ch <='f'){
                        count++;
                    }
                }
            }
        
        
        
            int keys= (1 << count) -1;
            int [][][] visited =new int[m][n][keys+1];
            
            while(!queue.isEmpty()){
                int [] cur = queue.poll();
                int x =cur[0];
                int y =cur[1];
                int steps =cur[2];
                int key = cur[3];
                
                if(key ==keys) return steps;
                
                for(int []dir : directions){
                    
                    int newX =x+dir[0];
                    int newY =y+dir[1];
                    
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX].charAt(newY) != '#'){
                        char ch=  grid[newX].charAt(newY);
                        if(ch >='A' && ch <= 'F'){
                            if(((key >> (ch -'A')) & 1) == 1 && visited[newX][newY][key]==0){
                                visited[newX][newY][key]=1;
                                queue.add(new int[]{newX,newY,steps+1,key});
                            }
                        }else if(ch >='a' && ch <='f'){
                            int newKey = key | (1 << (ch -'a'));
                            if(visited[newX][newY][newKey]==0){
                                 visited[newX][newY][newKey]=1;
                                 queue.add(new int[]{newX,newY,steps+1,newKey});
                            }
                        }else{
                            if(visited[newX][newY][key]==0){
                                visited[newX][newY][key]=1;
                                queue.add(new int[]{newX,newY,steps+1,key});    
                            }   
                        }    
                    }
                }    
            }
        return -1;  
    }
}    