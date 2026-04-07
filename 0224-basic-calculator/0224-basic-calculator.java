class Solution {
    int index =0;
    public int calculate(String s) {
        Stack<Integer> stack =new Stack<>();
        int num =0;
        char sign ='+';

        while(index <=s.length()){
            char c = index ==s.length() ? '#' : s.charAt(index);
            if(c ==' '){
                index++;
                continue;
            }else if(c=='('){
                index++;
                num =calculate(s);
            }else if(c==')'){
                index++;
                pushTostack(stack,num,sign);
                return getValue(stack);
            }else if(Character.isDigit(c)){
                index++;
                num =num *10 + c-'0';
            }else{
                pushTostack(stack,num,sign);
                sign =c;
                num =0;
                index++;
            }
        }
       return getValue(stack);
    }
    public void pushTostack(Stack<Integer> stack, int num, char sign){
        switch (sign) {
            case '+': 
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*' :
                stack.push(stack.pop()*num);
                break;
            case'/' :
                stack.push(stack.peek()/num);
                break;
        }
    }

     public int getValue(Stack<Integer> stack){
        int total =0;
        while(!stack.isEmpty()){
            total +=stack.pop();
        }
        return total;
    }
}