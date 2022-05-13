class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character,Set<Character>> map =new HashMap<>();
        int arr[] =new int[26];
        buildMap(map,arr,words);
        return BFS(map,arr);
    }
    
    public String BFS(HashMap<Character,Set<Character>> map,int arr[]){
        StringBuilder sb =new StringBuilder();
         int totalchars =map.size();
        Queue<Character> queue = new LinkedList<>();
        
        for(char c: map.keySet()){
            if(arr[c-'a']==0)queue.add(c);
        }
        
        while(!queue.isEmpty()){
            char c=queue.poll();
            sb.append(c);
            for( char neg : map.get(c)){
                arr[neg -'a']--;
                if(arr[neg-'a']==0){
                    queue.add(neg);
                }
            }
        }
        return sb.length()==totalchars ? sb.toString() :"";
    }
    
    public void  buildMap(HashMap<Character,Set<Character>> map,int arr[], String[] words){
        for(String word :words){
            for(char c:word.toCharArray()){
                 map.putIfAbsent(c,new HashSet<>());
            }
        }
        
        for(int i=0; i<words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            int len = Math.min(first.length(), second.length());
            for(int j=0; j<len; j++){
                if(first.charAt(j) != second.charAt(j)){
                    char out =first.charAt(j);
                    char in =second.charAt(j);
                  if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        arr[in -'a']++;
                    }
                    break;
                }
                if(j+1 ==len && first.length() > second.length()){
                    map.clear();
                    return;
                }
            }
            
        }
    }
}