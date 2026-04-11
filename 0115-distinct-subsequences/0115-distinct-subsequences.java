class Solution {
    Integer memo[][];
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
         return helper(s,t,s.length()-1,t.length()-1);
    }
    public int helper(String s, String t, int i, int j){
        if(j <0)return 1;
        if(i<0)return 0;
        if(memo[i][j] !=null)return memo[i][j];

        int val =0;
        if(s.charAt(i)==t.charAt(j)){
            val  += helper(s, t, i-1, j-1);
        }
        val += helper(s, t, i-1, j);
        return memo[i][j] =val;
    }
}