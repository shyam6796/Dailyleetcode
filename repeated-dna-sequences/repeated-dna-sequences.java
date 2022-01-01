class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i+10<=s.length(); ++i){
            String temp = s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.get(temp)==2 ){
    
                list.add(temp);
            }
        }
        return list;
    }
}