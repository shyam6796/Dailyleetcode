class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean bold [] = new boolean[s.length()];
        
        for(int start=0; start<s.length(); start++){
            int maxEnd =start-1;
            for(String word : words){
                if(word.isEmpty())continue;
                if(s.startsWith(word,start)){
                    maxEnd = start + word.length()-1;
                }
            }
            if(maxEnd<start){
                continue;
            }
            for(int i=start; i<=maxEnd; i++){
                bold[i]=true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(!bold[i]){
                sb.append(s.charAt(i));
                continue;
            }
            sb.append("<b>");
            int end =i;
            while(end<s.length() && bold[end]){
                end++;
            }
            sb.append(s.substring(i,end));
            sb.append("</b>");
            i=end-1;
        }
        return sb.toString();
    }
}