class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list =new ArrayList<>();
        HashMap<String,List<String>> map =new HashMap<>();
        
        for(String s:strings){
            String hashString =getHash(s);
            if(!map.containsKey(hashString)){
                map.put(hashString,new ArrayList<>());
            }
            map.get(hashString).add(s);
        }
        for(String s :map.keySet()){
                list.add(map.get(s));
        }
        return list;
    }
    
    public String getHash(String s){
        StringBuilder ans= new StringBuilder();
        for(int i=1; i<s.length(); i++){
            int x = s.charAt(i-1) -'0';
            int y = s.charAt(i) -'0';
            int diff = x-y <0 ? x-y+26 :x-y;
            ans.append(diff);
            ans.append("#");
        }
        return ans.toString();
    }
}