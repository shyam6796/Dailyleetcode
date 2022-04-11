class Solution {
    int index=0;
    public int calculate(String s) {
        Stack<Integer> stack =new Stack<>();
        int number=0;
        char sign='+';
        
        while(index <=s.length()){
            char c = index==s.length() ? '#' :s.charAt(index);
            if(c==' '){
                index++;
                continue;
                
            }
            if(c =='('){
                index++;
               number=calculate(s);
            }
            if(c ==')'){
                updateStack(stack,number,sign);
               return getResult(stack);
            }
            if(Character.isDigit(c)){
                    index++;
                    number = number *10 + c-'0';
            }else{
                    index++;
                     updateStack(stack,number,sign);
                    number=0;
                    sign=c;
                    
                }
               
            }
        return getResult(stack);
    }
    
    public  void updateStack(Stack<Integer> stack , int number, char sign){
        switch(sign){
            case '+' : stack.push(number); break;
            case '-' : stack.push(-number); break;
            case '*' : stack.push(number * stack.pop()); break;
            case '/' : stack.push(stack.pop() / number); break;
        }  
    }
    
    public int getResult(Stack<Integer> stack){
        int sum =0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}