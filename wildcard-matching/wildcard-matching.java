class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        dp[p.length()][s.length()] =true;
        
        for(int i=p.length()-1; i>=0; i--){
            for(int j=s.length(); j>=0; j--){
                    if(j==s.length()){
                        if(p.charAt(i)=='*'){
                            dp[i][j]=dp[i+1][j];
                            continue;
                        }
                    }else{
                        if(p.charAt(i)=='*'){
                            dp[i][j]=dp[i][j+1] || dp[i+1][j];
                        }
                        else if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
                            dp[i][j] = dp[i+1][j+1];
                        }
                    }
            }
        }
        return dp[0][0];
    }
}