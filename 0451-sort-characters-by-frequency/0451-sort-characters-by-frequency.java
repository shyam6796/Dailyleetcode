class Solution {
    public String frequencySort(String s) {
       Map<Character,Integer> map = new HashMap<>();
        int maxFreq =0;
        List<List<Character>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
           map.put(c,map.getOrDefault(c, 0)+1);
            maxFreq =Math.max(map.get(c),maxFreq);
        }

        for(int i =0; i <=maxFreq; i++)list.add(new ArrayList<>());

        for(char c : map.keySet()){
            int currFreq =map.get(c);
            list.get(currFreq).add(c);
        }

        for(int i =maxFreq; i>=1; i--){
            for(int j =0; j < list.get(i).size(); j++){
                int n =i;
                char c= list.get(i).get(j);
                while(n-->0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
        
    }
}