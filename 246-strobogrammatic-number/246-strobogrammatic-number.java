class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb =new StringBuilder();
        for(int i=0; i < num.length(); i++){
            char c = num.charAt(i);
            if(c=='1' || c=='0' || c=='8'){
                sb.append(c);
            }else if(c=='6'){
                sb.append('9');
            }else if(c=='9'){
                sb.append('6');
            }else return false;
        }
        return sb.reverse().toString().equals(num);
    }
}