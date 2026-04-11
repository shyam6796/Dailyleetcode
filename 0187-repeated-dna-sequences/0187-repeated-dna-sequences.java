class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map =new HashMap<>();
        int left =0;
        int right =10;

        while(right <=s.length()){
            String sub = s.substring(left,right);
            map.put(sub,map.getOrDefault(sub, 0)+1);
            left++;
            right++;
        }
        
        for(String str : map.keySet()){
            if(map.get(str) >1)list.add(str);
        }
        return list;
    }
}