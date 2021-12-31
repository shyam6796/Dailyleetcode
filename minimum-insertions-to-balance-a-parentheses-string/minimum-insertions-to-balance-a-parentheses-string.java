class Solution {
    public int minInsertions(String s) {
             Stack<Character> stack = new Stack<>();
            int insertionsNeeded = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    if (stack.isEmpty()) {
                        stack.add(c);
                    } else {
                        if (stack.peek() == ')') {
                          
                            insertionsNeeded++;
                            stack.pop();
                            stack.pop();
                            stack.add(c);
                        } else {
                            stack.add(c);
                        }
                    }
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                  
                        insertionsNeeded++;
                        stack.add('(');
                        stack.add(c);
                    } else {
                        if (stack.peek() == ')') {
                        
                            stack.pop();
                            stack.pop();
                        } else {
                            stack.add(c);
                        }
                    }
                }
            }
            if (stack.isEmpty()) {
                return insertionsNeeded;
            } else {
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') {
                        insertionsNeeded += 2;
                    } else {
                        insertionsNeeded++;
                        stack.pop();
                    }
                }
                return insertionsNeeded;
            }
        
    }
}