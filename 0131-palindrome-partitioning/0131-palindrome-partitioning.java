class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list,s,0,new ArrayList<>());
        return list;
    }

    public void backtrack(List<List<String>> list, String s, int index,  List<String> ans){
        if(index ==s.length()){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i=index+1; i <=s.length(); i++){
            String sub = s.substring(index,i);
            if(isPalindrome(s,index,i-1)){
                ans.add(sub);
                backtrack(list, s, i, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
     public boolean isPalindrome(String s, int left, int right){
        while(left < right){
           if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;  
    }
}