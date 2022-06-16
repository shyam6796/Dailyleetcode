class Solution {
    public boolean isPalindrome(int x) {
        int val =0, tar=x;
        while(x >0){
            val =val*10 +x%10;
            x /=10;
        }
        return tar ==val;
    }
}