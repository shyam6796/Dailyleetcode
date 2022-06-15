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
        
        Collections.sort(list, (a,b) ->  Integer.valueOf(a.get(1)) -Integer.valueOf(b.get(1)));
        
        Map<String,List<String>> map =new HashMap<>();
        
        for(List<String>log : list){
            List<String> pageList = map.getOrDefault(log.get(0), new ArrayList<>());
            pageList.add(log.get(2));
            map.put(log.get(0),pageList);
        }
        
        Map<String,Integer> counts =new HashMap<>();
         int max=0;
         String freqstring ="";
        for(String user : map.keySet()){
            Set<String> seq = helper(map.get(user));
            if(seq ==null)continue;
            
            for(String s :seq){
                counts.put(s, counts.getOrDefault(s,0)+1);
                if(counts.get(s)>max){
                    freqstring =s;
                    max=counts.get(s);
                }else if(counts.get(s)==max){
                    freqstring = s.compareTo(freqstring) < 0 ? s : freqstring ;
                }           
            }
        }
        
        return Arrays.asList(freqstring.split(","));
        
    }
    
    public Set<String> helper(List<String> list){
        if(list.size()<3)return null;
        Set<String> set =new HashSet<>();
        StringBuilder sb;
        for(int i=0; i<list.size()-2; i++){
            
            for(int j=i+1; j<list.size()-1; j++){
                 
                for(int k=j+1; k<list.size(); k++){
                    sb =new StringBuilder();
                    sb.append(list.get(i));
                    sb.append(",");
                    sb.append(list.get(j));
                    sb.append(",");
                    sb.append(list.get(k));
                    set.add(sb.toString());
                }
            }
        }
        return set;
    }
}