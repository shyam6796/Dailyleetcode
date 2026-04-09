class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int stars =0;

        for(int i =0; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i)==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    stars--;
                }
            }else if(s.charAt(i)=='(') stack.push('(');
            else stars++;
        }

       
        return stack.size() <=stars;
    }
}