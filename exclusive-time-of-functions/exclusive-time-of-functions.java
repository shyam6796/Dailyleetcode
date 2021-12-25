class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int results [] = new int[n];
         int prev =0, time =0, id=0;
        String  s[] =logs.get(0).split(":");
        id = Integer.valueOf(s[0]);
        stack.push(id);
        time = prev = Integer.valueOf(s[2]);
        
        for(int i =1; i<logs.size(); i++){
            
            s = logs.get(i).split(":");
            id = Integer.valueOf(s[0]);
            time =  Integer.valueOf(s[2]);
            
            if(s[1].equals("start")){
                if(!stack.isEmpty()) results[stack.peek()] += time-prev;
                    stack.push(id);
                    prev = time;
            }else{
                results[stack.pop()] += time-prev+1;
                prev = time+1;
                
            }
        }
        return results;
    }
}