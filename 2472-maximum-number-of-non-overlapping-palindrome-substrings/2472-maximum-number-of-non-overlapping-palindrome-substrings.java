class Solution {
    Integer memo [][];
    public int maxPalindromes(String s, int k) {
         if(k==1)return s.length();
        int n = s.length();
        memo = new Integer[n][n];

        return helper(s,n,0,k-1,k);
    }
    public int helper(String s, int n, int i, int j, int k){
        if(i >=s.length() || j >=s.length()){
            return 0;
        }

        if(memo[i][j] !=null)return memo[i][j];

        if(isValid(s.substring(i,j+1))){
           return memo[i][j] =  Math.max(1+ helper(s,n,j+1,j+k,k), Math.max(helper(s,n,i,j+1,k), helper(s,n,i+1,j+1,k)));
        }
        return memo[i][j] =  Math.max(helper(s,n,i,j+1,k), helper(s, n, i+1, j+1, k));
    }

    public boolean isValid(String s){
        int left =0;
        int right =s.length()-1;
        while(left <right){
            if(s.charAt(left ) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}