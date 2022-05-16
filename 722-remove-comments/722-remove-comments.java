class Solution {
    public List<String> removeComments(String[] source) {
        List<String> list =new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        boolean blockComment  =false;
        for(String s : source){
            char str[] =s.toCharArray();
            
            for(int i=0; i<str.length; i++){
                char c= str[i];
                if(!blockComment){
                    if(c != '/'){
                        sb.append(c);
                    }else{
                        if(i<str.length-1 && str[i+1]=='/') break;
                        else if(i<str.length-1 && str[i+1]=='*'){
                            blockComment =true;
                            i++;
                        }else{
                            sb.append(c);
                        }
                    }
                }else{
                    if(c == '*' && i<str.length-1 && str[i+1]=='/' ){
                          blockComment =false;
                            i++;
                     } 
                }
            }
            if (!blockComment){
			    if(sb.length()>0){
                    list.add(sb.toString());
                    sb =new StringBuilder();
                }
            }
        } 
        
       return list;     
    }
}