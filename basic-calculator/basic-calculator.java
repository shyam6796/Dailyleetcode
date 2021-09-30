class Solution {
    int index =0;
    public int calculate(String s) {
        char sign ='+';
        int number = 0;
        Stack<Integer> stack = new Stack();
        
        while(index<=s.length()){
              char curr = (index == s.length()) ? '#': s.charAt(index);
            if(curr == ' '){
                 index++;
                continue;
            }    
            if(curr =='('){
                index++;
                number=calculate(s);
            }
            else if(curr==')'){
                updateStack(stack, number,sign);
                return getResult(stack);
            }
            if(Character.isDigit(curr))number =(number * 10) + curr - '0';
            else{
                updateStack(stack, number,sign);
                sign =curr;
                number =0;
            }
            index++;
        }
        return getResult(stack);
    }
    
      public void updateStack(Stack<Integer> stackInst, int number, char sign) {
        switch(sign) {
            case '+': stackInst.push(number); break;
            case '-': stackInst.push(-number); break;
            case '*': stackInst.push(stackInst.pop() * number); break;
            case '/': stackInst.push(stackInst.pop() / number); break;   
        }
    }
    
    //// Add up all number from existing Stack to get result
    public int getResult(Stack<Integer> stackInst) {
        int res = 0;
        while(!stackInst.isEmpty()) res += stackInst.pop();
        return res;
    }
}