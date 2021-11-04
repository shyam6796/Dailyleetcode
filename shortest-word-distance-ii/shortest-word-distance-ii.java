class WordDistance {

         HashMap<String,ArrayList<Integer>> map;
    public WordDistance(String[] wordsDict) {
         map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++)
        {
            if(map.containsKey(wordsDict[i]))
            {
                ArrayList<Integer> tmp = map.get(wordsDict[i]);
                tmp.add(i);
                map.put(wordsDict[i],tmp);
            }
            else
            {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(wordsDict[i],tmp);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
           // int min = Integer.MAX_VALUE;
        ArrayList<Integer> index1 = map.get(word1);
        ArrayList<Integer> index2 = map.get(word2);
         int i=0 ,j=0;
        int min =Integer.MAX_VALUE;
        while(i<index1.size() && j< index2.size()){
            min = Math.min(min, Math.abs(index1.get(i) -index2.get(j)));
            if(index1.get(i) <index2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */