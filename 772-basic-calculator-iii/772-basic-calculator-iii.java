class Solution {
    int index =0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign ='+';
        
        while(index <=s.length()){
            char c = s.length() == index ? '#' : s.charAt(index);
            if(c == ' '){
                index++;
                continue;
            }
            if(c=='('){
                index++;
                num =calculate(s);
            }
            if(c==')'){
                 pushToStack(stack,sign,num);
               return getResult(stack);
            }
            if(Character.isDigit(c)){
                num =num *10 + c-'0';
                index++;
            }else{
                pushToStack(stack,sign,num);
                num=0;
                sign=c;
                index++;
            }
           
        }
         return getResult(stack);
    }
    
    public int getResult(Stack<Integer> stack){
        int ans=0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
    
    public void pushToStack(Stack<Integer> stack, char sign, int num){
        switch(sign){
            case '+' : stack.push(num); break;
            case '-' : stack.push(-num); break;
            case '*' : stack.push(num * stack.pop()); break;
            case '/' : stack.push(stack.pop()/num); break;
        }
    }
}