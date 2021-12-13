class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String,List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i],new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
        
        int dist=Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int i=0, j=0;
        
        while(i <l1.size() && j <l2.size()){
            dist = Math.min(dist, Math.abs(l1.get(i) - l2.get(j)));
            if(l1.get(i) < l2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return dist;
    }
}