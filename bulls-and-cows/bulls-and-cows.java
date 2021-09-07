class Solution {
    public String getHint(String secret, String guess) {
        
        HashMap<Character, Integer> h = new HashMap();
        for (char s : secret.toCharArray()) {
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
        int bulls=0,cows=0;
        for(int i =0; i<guess.length(); i++){
             if(h.containsKey(guess.charAt(i))){
                 if(guess.charAt(i)== secret.charAt(i)) {
                     bulls++;
                     
                     if (h.get(guess.charAt(i)) <= 0)cows--;
                 
                 }    
                 else {
                    if(h.get(guess.charAt(i)) >0)
                     cows++;
                 }
                 h.put(guess.charAt(i),h.get(guess.charAt(i))-1);
             }
        }
        return bulls+"A"+cows+"B";
    }
}