class Solution {
    int index=0;
    public int calculate(String s) {
        Stack<Integer> stack =new Stack<>();
        int num=0;
        char sign ='+';
        
        while(index <=s.length()){
            char c =index ==s.length() ? '#' : s.charAt(index);
            if(c==' '){
                index++;
                continue;
            }
            if(Character.isDigit(c)){
                num =num*10+ c -'0';
                index++;
            }else{
                pushStack(num,stack,sign);
                num=0;
                sign=c;
                index++;
            }
        }
        
        return getResult(stack);
    }
    
    public void pushStack(int num, Stack<Integer> stack, char sign){
        
          //System.out.println(sign + "   "+ num);
        switch(sign){
            case '+' : stack.push(num); break;
            case '-' : stack.push(-num); break;
            case '*' : stack.push(num * stack.pop()); break;
            case '/' : stack.push(stack.pop()/num); break;
        }
    }
    public int getResult(Stack<Integer> stack){
        int ans=0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}