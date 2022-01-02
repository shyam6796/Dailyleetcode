class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        List<String> list  = Arrays.asList(s.split("\\s+"));
        StringBuilder sb = new StringBuilder();
        for (int i=list.size()-1; i>=0; i--){
           String temp =list.get(i);
            if(temp.equals(" ")) continue;
            sb.append(list.get(i));
             sb.append(" ");
        }
        return sb.toString().trim();
        
    }
}