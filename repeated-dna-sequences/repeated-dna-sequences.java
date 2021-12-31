class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int i=0;
        
        while(i+10 <=s.length()){
            String subString = s.substring(i,i++ + 10);
            map.put(subString, map.getOrDefault(subString,0)+1);
            if(map.get(subString) ==2){
                list.add(subString);
            }
        }
        return list;
    }
}