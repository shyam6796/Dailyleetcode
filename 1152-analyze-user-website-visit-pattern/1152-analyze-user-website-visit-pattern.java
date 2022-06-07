class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<List<String>> list = new ArrayList<>();
        
        for(int i=0; i<username.length; i++){
              List<String> log =new ArrayList<>();
             log.add(username[i]);
             log.add(timestamp[i]+"");
             log.add(website[i]);
             list.add(log);            
        }
        Collections.sort(list,(l1,l2) -> Integer.valueOf(l1.get(1)) -Integer.valueOf(l2.get(1)));
        
        Map<String,List<String>> map = new HashMap<>();
        
        for(List log1 : list){
            List<String> log= log1;
            List<String> pageList = map.getOrDefault(log.get(0), new ArrayList<>());
            pageList.add(log.get(2));
            map.put(log.get(0),pageList);
        }
        
        Map<String,Integer> counts = new HashMap<>();
        int max=0;
        String freqstring ="";
        for(String user : map.keySet()){
            Set<String> seq =getAllSequnce(map.get(user));
            if(seq ==null){
                continue;
            }
            for(String s :seq){
                if(!counts.containsKey(s)){
                    counts.put(s,0);
                }
                counts.put(s,counts.get(s)+1);
                if(max<counts.get(s)){
                    max=counts.get(s);
                    freqstring=s;
                }else if(max== counts.get(s)){
                    freqstring = s.compareTo(freqstring) < 0 ? s : freqstring;
                }
            }
            
        }
        return Arrays.asList(freqstring.split(",")); 
    }
        public Set<String> getAllSequnce(List<String> pages){
            if(pages.size()<3){
                return null;
            }
            Set<String> ans = new HashSet<>();
            int size= pages.size();
            for(int i=0; i<size-2; i++){
                for(int j=i+1; j<size-1; j++){
                    for(int k=j+1; k<size; k++){
                        StringBuilder sb = new StringBuilder(pages.get(i));
                        sb.append(',');
                        sb.append(pages.get(j));
                        sb.append(',');
                        sb.append(pages.get(k));
                        ans.add(sb.toString());
                }
            }
        }
            return ans;
    }
}