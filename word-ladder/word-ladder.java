class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set =new HashSet<>(wordList);
         Set<String> seen = new HashSet<>();
        if(!set.contains(endWord))return 0;
       
        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0; i<size; i++){
                String word=queue.poll();
                char w[] =word.toCharArray();
                for(int j=0; j<w.length; j++){
                    char c =w[j];
                    for(char a ='a'; a<='z'; a++){
                        if(a==c)continue;
                        w[j]=a;
                        String newWord =String.valueOf(w);
                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                         if(!seen.contains(newWord) && set.contains(newWord) ){
                             queue.add(newWord);
                            seen.add(newWord);
                        }
                    }
                    w[j]=c;
                }    
            }
            level++;
        }
         return 0;
    }
}