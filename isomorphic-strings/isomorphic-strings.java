class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> map =new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));    
                }else return false;
                
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb.append(map.get(s.charAt(i)));
        }
        
        if(sb.toString().equals(t)){
            return true;
        }else{
           return false; 
        }
        }
}