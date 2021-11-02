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
            int min = Integer.MAX_VALUE;
        ArrayList<Integer> index1 = map.get(word1);
        ArrayList<Integer> index2 = map.get(word2);
        for(int i: index1)
        {
            for(int j: index2)
            {
                if(Math.abs(i-j)<min)
                {
                    min = Math.abs(i-j);
                }
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