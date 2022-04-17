class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(int i=0; i<strings.length; i++){
            String s =getHash(strings[i]);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(strings[i]);
        }
        
        for(String s : map.keySet()){
            list.add(map.get(s));
        }
        
        return list;
    }
    
    public String getHash(String str){
        StringBuilder sb=  new StringBuilder();
        for(int i=1; i<str.length(); i++){
            int x =str.charAt(i-1) -'a' ;
            int y =str.charAt(i) -'a';
            int diff= x-y >=0 ? x-y : x-y+26;
            sb.append(diff);
            sb.append("#");
        }
        return sb.toString();
    }
}