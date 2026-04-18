class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(s,set,map);
    }

    public List<String> helper(String s, Set<String> set, Map<String,List<String>> map){
        if(s.equals("")|| s==null)return new ArrayList<>();
        if(map.containsKey(s)) return map.get(s);
         List<String> list = new ArrayList<>();
         if(set.contains(s))list.add(s);

        for(int i = 0; i <= s.length(); i++){
            String a = s.substring(0,i);
            String b = s.substring(i);

            if(set.contains(a)){
                List<String> temp = helper(b,set,map);
                if(temp !=null){
                    
                    for(String str : temp){
                        list.add(a +" "+ str);
                    }
                    
                }
            }
        }
        map.put(s,list);
        return list;
    }
}