class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean arr[] = new boolean[s.length()];
        int end=0;
        for(int start=0; start<s.length(); start++){
             end = start-1;
            for(String word :words){
                if(s.startsWith(word,start)){
                    end =start+word.length();
                }
                if(start >end) continue;
                 for(int i=start; i<end; i++){
                    arr[i]=true;
                }
            }
            
        }
    
    int index=0;
    StringBuilder sb = new StringBuilder();
    
    while(index<s.length()){
        if(!arr[index]){
            sb.append(s.charAt(index));
            index++;
            continue;
        }else{
            sb.append("<b>");
            while( index <s.length() && arr[index]){
                sb.append(s.charAt(index++));
            }
            sb.append("</b>");
        }
    }
    return sb.toString();
    }
}