class Solution {
    public String customSortString(String order, String s) {
        int [] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i) -'a']++;
        }
        StringBuilder sb =new StringBuilder();
        
        for(int i =0; i<order.length(); i++){
            for(int j =0; j < map[order.charAt(i)- 'a']; j++){
                sb.append(order.charAt(i));
            }
             map[order.charAt(i)- 'a']=0;
        }
        
       for(char c='a'; c<='z'; c++){
           for(int j =0; j < map[c- 'a']; j++){
            sb.append(c);
            }
        }
        
        return sb.toString();
    }
}