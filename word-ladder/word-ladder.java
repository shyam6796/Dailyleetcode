class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> seen = new HashSet<>();
        if(!wordList.contains(endWord))return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);
        int level =1;
        
        while(!queue.isEmpty()){
            int n =queue.size();
            for(int i=0; i<n; i++){
                String s =queue.poll();
               // System.out.println(s);
                char arr[]= s.toCharArray();
                for(int k=0; k<arr.length; k++){
                    char c =arr[k];
                    for(char j='a'; j<='z'; j++){
                        if(c==j)continue;
                        arr[k]=j;
                        String newWord =String.valueOf(arr);
                        if(newWord.equals(endWord))return level+1;
                        if(set.contains(newWord) && !seen.contains(newWord)){
                                seen.add(newWord);
                                queue.add(newWord);
                        }
                        
                       
                    }
                     arr[k]=c;
                }
            }
            level++;
        }
        return 0;
        
    }
}