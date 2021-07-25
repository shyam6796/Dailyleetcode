class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
           return wordBreakhelpr(s,wordDict,new HashMap<String,List<String>>());
    }
    public List<String> wordBreakhelpr(String s,List<String> wordDict, HashMap<String,List<String>> map){
        List<String> ans =new ArrayList<>();
        if(s.length()==0){
            ans.add("");
            return ans;
        }
        if(map.containsKey(s))return map.get(s);
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                String sub = s.substring(word.length());
                List<String> subString = wordBreakhelpr(sub,wordDict,map);
                for(String temp : subString){
                    String optnialspace = temp.isEmpty() ?"": " ";
                    ans.add(word + optnialspace + temp);
                }
            }
        }
        
        map.put(s,ans);
        return ans;
        
    }
}