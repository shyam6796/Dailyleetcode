class Solution {
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        HashMap<String,Integer> map = new HashMap<>();
          int maxLen = 1;
        for(int i=0; i <words.length; i++){
            int chainLen = 1;
            String s =words[i];
            for(int j=0;j<s.length(); j++){
                String temp = s.substring(0,j) + s.substring(j+1);
                    chainLen = Math.max(chainLen, map.getOrDefault(temp, 0) + 1);
                
            }
             map.put(s, chainLen);
            maxLen = Math.max(maxLen, chainLen);
        }
       // System.out.println(map);
        return maxLen;
    }
}