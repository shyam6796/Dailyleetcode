class Solution {
    public boolean validPalindrome(String s) {
        return helper(s,0,s.length()-1,true);
    }
    public boolean helper(String s, int left, int right, boolean flag){
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }
            if(flag){
                if(helper(s,left+1,right,false))return true;
                else return helper(s,left,right-1,false);
            }else return false;
        }
        return true;
    }
}