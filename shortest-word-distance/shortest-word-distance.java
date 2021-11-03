class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
            Map<String, List<Integer>> map = new HashMap<>();
             
            for(int i=0; i<wordsDict.length; i++){
                if(!map.containsKey(wordsDict[i])){
                     map.put(wordsDict[i] ,new ArrayList<>());
                   
                } 
                map.get(wordsDict[i]).add(i);
            }
      
        List<Integer> loc1, loc2;
        loc1 =map.get(word1);
        loc2 =map.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }
}