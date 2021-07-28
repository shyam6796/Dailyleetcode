class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuffer rev1 =new StringBuffer(s);
        rev1.reverse();
        String rev =rev1.toString();
        System.out.println(rev);
        
        for (int i = 0; i < n; i++) {
        if (s.substring(0, n - i).equals(rev.substring(i)))
            return rev.substring(0, i) + s;
    }   
    return "";
        
    }
}