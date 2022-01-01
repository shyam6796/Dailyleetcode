class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack();
        int insert =0;
        
        for(char c :s.toCharArray()){
            if(c == '('){
                if(st.isEmpty()){
                    st.push(c);
                }else if(st.peek() == ')'){
                    insert++;
                    st.pop();
                    st.pop();
                    st.push(c);
                }else{
                    st.push(c);
                }
            }else if(c ==')'){
                if(st.isEmpty()){
                    insert++;
                    st.push('(');
                    st.push(')');
                }else if(st.peek() ==')'){
                    st.pop();
                    st.pop();
                }else {
                    st.push(c);
                }
            }
            
        }
        
        if(st.isEmpty()) return insert;
        
        while(!st.isEmpty()){
            char c= st.pop();
            if(c=='('){
                insert+=2;
                
            }else{
                insert++;
                st.pop();
               
            }
        }
        return insert;
    }
}