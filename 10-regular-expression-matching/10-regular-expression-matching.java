class Solution {
    public boolean isMatch(String s, String p) {
        int X =p.length();
        int Y =s.length();
        
        boolean[][] dp = new boolean[X+1][Y+1];
        dp[0][0]=true;
        for(int i=1; i<=X; i++){
            for(int j=0; j<=Y; j++){
                if( j==0){
                    if(p.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-2][j];
                    }
                }else{
                    if(p.charAt(i-1)=='*'){
                        dp[i][j] = dp[i-2][j];
                        
                        if(p.charAt(i-2)==s.charAt(j-1) || p.charAt(i-2)=='.' ){
                             dp[i][j] = dp[i-2][j] || dp[i][j-1];
                        }
                    }else if(p.charAt(i-1)=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        if(p.charAt(i-1)==s.charAt(j-1))
                            dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[X][Y];
        
    }
}