class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        String [] str1 = s1.split(" ");
        String [] str2 = s2.split(" ");
        List<String> list = new ArrayList<>();
        for(String s : str1){
            if(!map.containsKey(s)){
                map.put(s,0);
            }
            map.put(s,map.get(s)+1);
        }
        
        for(String s : str2){
            if(!map.containsKey(s)){
                map.put(s,0);
            }
            map.put(s,map.get(s)+1);
        }
        for(String s :map.keySet()){
            if(map.get(s)==1){
                list.add(s);
            }
        }
        String[] array = new String[list.size()];
        list.toArray(array);
        return array;
    }
}