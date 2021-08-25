class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set =new  HashSet<>();
        for(String i :deadends){
            set.add(i);
        }
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int level =0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                String current = queue.poll();
                if(set.contains(current)){
                    size--;
                    continue;
                }
                if(current.equals(target)){
                    return level;
                }
                StringBuilder sb =new StringBuilder(current);
                for(int i=0; i<4; i++){
                    char c =sb.charAt(i);
                    String s1 =sb.substring(0,i) +(c == '9' ? 0 : c-'0'+1) + sb.substring(i+1);
                    String s2 =sb.substring(0,i) +(c == '0' ? 9 : c-'0'-1) + sb.substring(i+1);
                    if(!visited.contains(s1) && !set.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !set.contains(s2)){
                        queue.offer(s2);
                        visited.add(s2);
                    }
                    
                }
                
                size--;
            }
            level++;
                    
            
        }
        return -1;
    }
}