class Solution {
    Integer memo[][];
    public int maxPalindromes(String s, int k) {
        if(k==1)return s.length();
        memo = new Integer[s.length()][s.length()];
       return  helper(s,0,k-1,k);
    }

    public int helper(String s, int i, int j, int k){
        if(j >=s.length() || i >=s.length())return 0;

        if(memo[i][j] !=null)return memo[i][j];

        //int ans =0;
        if(isPalindrome(s, i, j)){// 1 + always next windo
          return memo[i][j] =Math.max(1+ helper(s, j+1, j+k, k), Math.max(helper(s,i,j+1,k), helper(s, i+1, j+1, k)));
        }
        return memo[i][j] = Math.max(helper(s,i,j+1,k),  helper(s, i+1, j+1, k));


    }
    private boolean isPalindrome(String s, int start, int end) {
          while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}