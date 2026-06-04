class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
       
        int index =0;

        while(index < words.length){
            int i=index+1;
            int totalchars = words[index].length();
            while(i < words.length  && totalchars + words[i].length() +1 <=maxWidth){
                totalchars +=words[i].length()+1;
                i++;
            }
            int count =i-index-1;
             StringBuilder sb =new StringBuilder();
            if(count==0 || i ==words.length){
                
                for(int j =index; j<i; j++){
                    sb.append(words[j] +" ");
                }
                sb.deleteCharAt(sb.length()-1);
                while(sb.length() <maxWidth)sb.append(" ");
            }else{
                //int count =i-index-1;
                int evenSpaces =(maxWidth-totalchars)/count;
                int oddSpaces = (maxWidth-totalchars)%count;
                 for(int j =index; j<i-1; j++){
                    sb.append(words[j] +" ");
                    sb.append(" ".repeat(evenSpaces));
                    if(oddSpaces-- >0)sb.append(' ');
                }
                sb.append(words[i-1]);
            }
            list.add(sb.toString());
            index =i;
        }

        return list;
    
    }
}