class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        List<String> ans =new ArrayList<>();
        for(String s : words){
            set.add(s);
        }
        
        for(String s :words){
            if(s.length()==0){
                continue;
            }
            set.remove(s);
            boolean dp[] =new boolean[s.length()+1];
            dp[0]=true;
            for(int i=0; i<=s.length(); i++){
                for(int j=0; j<i; j++){
                    if(dp[j] && set.contains(s.substring(j,i))){
                        dp[i]=true;
                        break;
                    }
                }
            }
            if(dp[s.length()]==true){
                ans.add(s);
            }
            set.add(s);
        }
        return ans;
    }
}