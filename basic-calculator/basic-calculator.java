class Solution {
    int index =0;
    public int calculate(String s) {
        char sign ='+';
        int number = 0;
        Stack<Integer> stack = new Stack();
        
       while(index <=s.length()){
           char c = index == s.length() ? '#': s.charAt(index);
           if(c ==' '){
               index++;
               continue;
           }else if(c == '('){
               index++;
               number = calculate(s);
           }else if( c ==')'){
               updateStack(stack,number,sign);
               return getResult(stack);
           }
           if(Character.isDigit(c)){
               index++;
               number =number *10 +c-'0';
           }else{
                index++;
               updateStack(stack,number,sign);
               sign =c;
               number =0;
           }
       }
        return getResult(stack);
    }    
        public void updateStack(Stack<Integer> stack, int number, char sign){
            switch(sign){
                case '+' : stack.push(number); break;
                case '-' : stack.push(-number);  break;
                case '*' : stack.push(stack.pop() * number); break;
                case '/' : stack.push(stack.pop() / number); break;
            }
        }
        
        public int getResult(Stack<Integer> stack){
            int result =0;
            while(!stack.isEmpty()){
                result += stack.pop();
            }
            return result;
        }
}