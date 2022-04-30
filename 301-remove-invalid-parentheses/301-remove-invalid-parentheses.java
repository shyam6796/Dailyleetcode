class Solution {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> list =new ArrayList<>();
        int numOfRemoval =helper(s);
        helper2(list,numOfRemoval,s);
        return list;
    }
    
    public int helper(String s){
        Stack<Character> stack =new Stack();
        for(char c :s.toCharArray()){
            if(c=='('){
                stack.add(c);
            }else if(c==')'){
                if(!stack.isEmpty() && stack.peek() =='(') stack.pop();
                else stack.push(c);
            }
        }
        
        return stack.size();
    }
    
    public void helper2(List<String> list, int k, String s){
        if(set.contains(s))return;
        set.add(s);
        if(k==0 && helper(s) ==0){
            list.add(s);
            return;
        }
        for(int i=0; i<s.length(); i++){
            String left =s.substring(0,i);
            String right=s.substring(i+1);
            helper2(list,k-1,left+right);
        }
    }
}