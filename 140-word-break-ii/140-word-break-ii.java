class Solution {
    Map<String,List<String>> map =new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list =new ArrayList<>();
        if(s.equals("")){
            list.add("");
            return list;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                String subWord = s.substring(word.length());
                List<String> subList = wordBreak(subWord,wordDict);
                for(String temp : subList){
                    String space = temp.length()==0 ? "" : " ";
                    list.add(word + space+temp);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}