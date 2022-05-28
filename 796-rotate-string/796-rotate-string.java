class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb =new StringBuilder(s);
        
        for(int i=0; i<s.length(); i++){
            char c =sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0,c);
            
            if(sb.toString().equals(goal))return true;
        }
        return false;
    }
}