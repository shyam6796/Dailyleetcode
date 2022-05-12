class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> map = new HashMap<>();
        int indegree[] =new int[26];
        buildGraph(map, indegree, words);
        return bfs(map,indegree);
    }
    
    public String bfs(Map<Character,Set<Character>> map, int indegree[]){
        StringBuilder sb = new StringBuilder();
        int totalchars =map.size();
        Queue<Character> queue = new LinkedList<>();
        
        for(char c : map.keySet()){
            if(indegree[c-'a']==0){
                queue.add(c);
                
            }
        }
        
        while(!queue.isEmpty()){
            char c =queue.poll();
            sb.append(c);
            for(char neg : map.get(c)){
                indegree[neg -'a']--;
                if(indegree[neg -'a'] ==0){

                    queue.add(neg);
                    
                }
            }
        }
        
        return sb.length() == totalchars ? sb.toString() : "";
        
    }
    
    public void buildGraph(Map<Character,Set<Character>> map, int indegree[], String[] words){
         for(String word : words){
             for(char c :word.toCharArray()){
                 map.putIfAbsent(c,new HashSet<>());
             }
         }
        
        for(int i=1; i<words.length; i++){
            String first =words[i-1];
            String second =words[i];
            int len = Math.min(first.length(), second.length());
            for(int j=0; j<len; j++){
                if(first.charAt(j) != second.charAt(j)){
                    char out =first.charAt(j);
                    char in = second.charAt(j);
                    if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        indegree[in -'a']++;
                    }
                    break;
                }
                if (j + 1 == len && first.length() > second.length()) {
                    map.clear();
                    return;
                }
                
            }
        }
    }
}