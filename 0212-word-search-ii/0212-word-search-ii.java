class Solution {
    class Trie{
        Trie children [] = new Trie[26];
        String str =null;

    }
    Trie root =new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
         boolean visited [][] = new boolean[board.length][board[0].length];
        for(String word: words){
            addWord(word);
        }

        for(int i =0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                if(root.children[board[i][j] -'a'] !=null){
                    DFS(list,board,i,j,root,visited);
                }
            }
        }
        return list;
    }
    public void addWord(String word){
        Trie curr =root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] ==null)curr.children[c-'a'] = new Trie();
            curr =curr.children[c -'a'];
        }
        curr.str =word;
    }

    public void DFS(List<String> list, char board[][], int i, int j, Trie curr, boolean [][] visited ){
        if(i <0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || curr.children[board[i][j]-'a']==null)return;

        curr =curr.children[board[i][j]-'a'];
        if(curr.str !=null){
            list.add(curr.str);
            curr.str = null;
        }

        visited[i][j] =true;

        DFS(list, board, i+1, j, curr,visited);
        DFS(list, board, i, j+1, curr,visited);
        DFS(list, board, i-1, j, curr,visited);
        DFS(list, board, i, j-1, curr,visited);

        visited[i][j] =false;
    }
}