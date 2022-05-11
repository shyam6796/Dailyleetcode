class Solution {
    Map<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list =new ArrayList<>();
        if(s.equals("")){
            list.add("");
            return list;
        }
        
        if(map.containsKey(s))return map.get(s);
        
        for(String word :wordDict){
            if(s.startsWith(word)){
                String subWord =s.substring(word.length());
                List<String> subList =wordBreak(subWord,wordDict);
                for(String t : subList){
                    String space = t.length()==0 ?"" : " ";
                    list.add(word +space+t);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}