class Solution {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int minRemove =helper(s);
       // System.out.println(minRemove);
        helper2(list,minRemove,s);
        return list;
    }
     public  void  helper2(List<String> list, int minRemove, String s){
         if(set.contains(s))return;
         set.add(s);
         if(minRemove==0){
            if(helper(s)==0)list.add(s);
            return;
        }
         for(int i=0; i<s.length(); i++){
            String left =s.substring(0,i);
            String right =s.substring(i+1);
            
            if(!set.contains(left+right)) helper2(list,minRemove-1, left+right);
        }
     }
    
    public  int helper(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) =='(' || s.charAt(i) ==')')stack.push(s.charAt(i));
                continue;
            }else{
                if(s.charAt(i) =='('){
                    stack.push(s.charAt(i));
                }else if(s.charAt(i) ==')' && stack.peek()=='('){
                        stack.pop();
                }else if(s.charAt(i) ==')'){
                    stack.add(s.charAt(i));
                }
            }
        }
        return stack.size();
    } 
}