class Solution {
    Integer[] dp;
    Boolean[][] palindrome;
    public int minCut(String s) {
        dp= new Integer[s.length()];
        palindrome =new Boolean[s.length()][s.length()];
        return helper(s,0,s.length()-1);
    }
    public int helper(String s, int left, int right){
        if(left ==right || isPalindrome(s, left, right))return 0;
        int min =right-left;

        if(dp[left]!=null)return dp[left];

        for(int i=left; i<=right; i++){
            if(isPalindrome(s,left,i)){
                min =Math.min(min, 1 + helper(s, i+1, right));
            }
        }
        return dp[left]=min;
    }
     private boolean isPalindrome(String s, int start, int end) {
         if (start >= end) {
            return true;
        }
        if(palindrome[start][end] !=null)return palindrome[start][end];

        return palindrome[start][end] = (s.charAt(start) ==s.charAt(end) )&& isPalindrome(s, start+1, end-1);
    }
}