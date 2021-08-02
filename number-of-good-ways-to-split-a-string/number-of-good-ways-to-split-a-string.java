class Solution {
    public int numSplits(String s) {
        int count = 0;
        char[] charArr = s.toCharArray();
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        map1.put(charArr[0], 1);
        
        for(int i = 1; i < charArr.length; i++)
            map2.put(charArr[i], map2.getOrDefault(charArr[i], 0) + 1);
        
        if(map1.keySet().size() == map2.keySet().size())
                count++;
        
		// Sliding Window
        for(int i = 1; i < charArr.length; i++){
            map1.put(charArr[i], map1.getOrDefault(charArr[i], 0) + 1);
            
            map2.put(charArr[i], map2.get(charArr[i]) - 1);
            map2.values().removeIf(value -> value == 0);
            if(map1.keySet().size() == map2.keySet().size())
                count++;
            
        }
        return count;
    }
}