class Solution {
    public int shortestWay(String source, String target) {
        int ans=0;
        String remaining =target;
       
        
        while(remaining.length() >0 ){
            StringBuilder sb = new StringBuilder();
             int i=0;
            int j=0;
            while(i<source.length() && j<remaining.length()){
                if(source.charAt(i++) ==remaining.charAt(j)){
                    sb.append(remaining.charAt(j++));
                }
                
            }
            if(sb.length()==0){
                return -1;
            }
            ans++;
            remaining = remaining.substring(sb.length());
        }
        return ans;
    }
}