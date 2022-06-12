class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if(s.equals(goal)){
            int [] arr =new int[26];
            for(int i=0; i<s.length(); i++){
                arr[s.charAt(i)-'a']++;
            }
            for(int i :arr){
                if(i>1)return true;
            }
            return false;
        }
        int first =-1, second =-1;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==goal.charAt(i))continue;
            else{
                if(first==-1){
                    first=i;
                }else if(second ==-1){
                    second = i;
                }else return false;
            }
        }
        return (second != -1 && s.charAt(first)==goal.charAt(second) && s.charAt(second)==goal.charAt(first));
    }
}