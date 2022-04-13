class Solution {
    public boolean isNumber(String s) {
        boolean isDigit =false;
        boolean eSeen =false;
        boolean dotSeen =false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                isDigit =true;
                continue;
            }else if(c =='e' || c == 'E'){
                if(eSeen || !isDigit)return false;
                eSeen =true;
                isDigit=false;
            }else if(c=='.'){
                if(dotSeen || eSeen)return false;
                dotSeen=true;
            }else if(c== '+' || c=='-'){
                if(i ==0 || s.charAt(i-1) =='e' || s.charAt(i-1) =='E')continue;
                else return false;
            }else return false;
        }
        
        return isDigit;
    }
}