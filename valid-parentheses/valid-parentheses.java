class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c =='{' || c=='[' || c=='('){
                sk.push(c);
            }else{
                
                if(sk.isEmpty())return false;
                if(c=='}' && sk.peek() =='{'){
                    sk.pop();
                } else if(c==']' && sk.peek() =='['){
                    sk.pop();
                }else if(c==')' && sk.peek() =='('){
                    sk.pop();
                }else{
                    return false;
                }
            }
        }
        return sk.isEmpty();
    }
}