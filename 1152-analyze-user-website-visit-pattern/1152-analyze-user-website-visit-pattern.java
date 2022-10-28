class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<List<String>> list =new ArrayList<>();
        
        for(int i=0; i<username.length; i++){
            List<String> temp = new ArrayList<>();
            temp.add(username[i]);
            temp.add(timestamp[i]+"");
            temp.add(website[i]);
            list.add(temp);
        }
        
        Collections.sort(list,(a,b) -> Integer.valueOf(a.get(1)) -Integer.valueOf(b.get(1)));
        Map<String,List<String>> map = new HashMap<>();
        
        for(List<String> log : list){
            List<String> pages =map.getOrDefault(log.get(0),new ArrayList<>());
            pages.add(log.get(2));
            map.put(log.get(0),pages);
        }
        
        HashMap<String,Integer> count =new HashMap<>();
        int max=0;
        String freqString="";
        for(String user : map.keySet()){
            Set<String> set =helper(map.get(user));
            if(set==null)continue;
            for(String s :set){
                count.put(s,count.getOrDefault(s,0)+1);
                if(max<count.get(s)){
                    freqString =s;
                    max =count.get(s);   
                }
                else if(max ==count.get(s)){
                    freqString = s.compareTo(freqString) >=0 ?freqString : s;
                }
            }
        }
            
            return Arrays.asList(freqString.split(","));
    }
        
        public Set<String> helper(List<String> pages){
            Set<String> set1 =new HashSet<>();
            for(int i=0; i<pages.size()-2; i++){
                for(int j=i+1; j<pages.size()-1; j++){
                    for(int k=j+1; k<pages.size(); k++){
                        StringBuilder sb =new StringBuilder();
                        sb.append(pages.get(i));
                        sb.append(",");
                        sb.append(pages.get(j));
                        sb.append(",");
                        sb.append(pages.get(k));
                        set1.add(sb.toString());
                    }
                }
            }
            return set1;
        }
    
}