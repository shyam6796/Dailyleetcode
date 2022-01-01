class Solution {
    public boolean isNumber(String s) {
        boolean numSeen =false;
        boolean eSeen =false;
        boolean dotSeen = false;
        
        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                numSeen =true;
            }else if(c=='e' || c=='E'){
                if(eSeen || !numSeen)return false;
                else{
                    eSeen = true;
                    numSeen = false;
                }
            }else if(c=='.'){
                if(dotSeen || eSeen)return false;
                else dotSeen =true;
            }else if(c=='+' || c=='-'){
                if(i !=0 && s.charAt(i-1) !='E' && s.charAt(i-1) != 'e' ){
                    return false;
                }
            }else return false;
        }
        return numSeen;
    }
}