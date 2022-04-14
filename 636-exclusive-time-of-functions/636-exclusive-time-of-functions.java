class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] ans = new int[n];
        Stack<Integer> stack =new Stack<>();
        String [] log =logs.get(0).split(":");
        int id =Integer.valueOf(log[0]);
        int timeStamp = Integer.valueOf(log[2]);
        int lastTime =timeStamp;
        String s =log[1];
        stack.add(id);
        
        for(int i=1; i<logs.size(); i++){
            log = logs.get(i).split(":");
            id =Integer.valueOf(log[0]);
            timeStamp =Integer.valueOf(log[2]);
            s =log[1];
            if(s.equals("start")){
                if(!stack.isEmpty())ans[stack.peek()] += timeStamp-lastTime;
                lastTime =timeStamp;
                stack.push(id);
            }else{
               ans[stack.pop()] += timeStamp-lastTime+1;
                lastTime =timeStamp+1;
            }
            
        }
        return ans;
    }
}