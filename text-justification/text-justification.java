class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n =words.length;
        int index=0;
        
        while(index <n){
            int totalChars = words[index].length();
            int last = index+1;
            
            while(last< n){
               if(totalChars + 1 + words[last].length() >maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int gaps = last -index -1;
            StringBuilder sb = new StringBuilder();
            
            if(last==n || gaps==0){
                
                for(int i=index; i<last; i++){
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length()-1);
                
                while(sb.length()<maxWidth){
                    sb.append(' ');
                }
                
            }else{
                
                int space = (maxWidth -totalChars)/gaps;
                int rest = (maxWidth -totalChars)%gaps;
                
                for(int i=index; i<last-1; i++){
                    sb.append(words[i]);
                    sb.append(' ');
                    
                    for(int j=0; j< space + (rest > i-index ?1 :0); j++){
                           sb.append(' '); 
                    }
                    
                }
                sb.append(words[last-1]);
            }
            index =last;
            res.add(sb.toString());
        }
        
        return res;
    }
}