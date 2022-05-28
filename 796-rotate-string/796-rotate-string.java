class Solution {
    public boolean rotateString(String s, String goal) {
                String res=goal+goal;
        if(s.length()==goal.length())
        {
            if(res.contains(s))
                return true;
            else
                return false;
        }else
            return false;   
    }
}