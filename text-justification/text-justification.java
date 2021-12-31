class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n =words.length;
        int index =0;
        
        while(index<n){
            int totalChar = words[index].length();
            int last =index+1;
            
            while(last<n){
                if(totalChar + 1+ words[last].length() >maxWidth )break;
                totalChar += 1+ words[last].length();
                last++;
            }
            
            int gaps = last -index-1;
            StringBuilder sb = new StringBuilder();
            if(last ==n || gaps==0){
                
                for(int i=index; i<last; i++){
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length()-1);
                
                while(sb.length()<maxWidth){
                    sb.append(' ');
                }
            }else{
                
                int space =(maxWidth- totalChar)/gaps;
                int extra  =(maxWidth- totalChar)%gaps;
                
                for(int i= index; i<last-1; i++){
                    sb.append(words[i]);
                    sb.append(' ');
                    
                    for(int j=0; j<space + (extra > i-index ?1:0); j++){
                        sb.append(' ');
                    }
                }
                sb.append(words[last-1]);
            }
            index =last;
            list.add(sb.toString());
        }
        return list;
    }
}