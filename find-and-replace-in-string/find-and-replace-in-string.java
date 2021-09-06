class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
           HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<indices.length; i++){
            map.put(indices[i],i);
        }
           StringBuilder sb  = new StringBuilder();
        
        int i=0;
        while(i<s.length()){
              if(map.containsKey(i)){
                    String source = sources[map.get(i)];
                    String target = targets[map.get(i)];
                    String temp = s.substring(i, i+ source.length());
                    if(temp.equals(source)){
                         sb.append(target);
                            i=i+source.length();
                    }else{
                        sb.append(s.charAt(i));
                        i++;
                    }
              }else{
                  sb.append(s.charAt(i));
                  i++;
              }  
            
        }
        
            
        
        return sb.toString();
    }
   
}