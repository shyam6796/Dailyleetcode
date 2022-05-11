class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int orderMap [] =new int[26];
        for(int i=0; i<order.length(); i++){
            orderMap[order.charAt(i)-'a']=i;
        }
        
        for(int i=1; i<words.length; i++){
            String first=words[i-1];
            String second =words[i];
            //if(first.length() > second.length()) 
            for(int j=0; j<first.length(); j++){
                if(j>=second.length())return false;
                if(first.charAt(j)==second.charAt(j)){
                    continue;
                }else{
                    int x = orderMap[first.charAt(j)-'a'];
                    int y = orderMap[second.charAt(j)-'a'];
                    if(x>y)return false;
                    else break;
                }
            }
        }
        return true;
    }
}