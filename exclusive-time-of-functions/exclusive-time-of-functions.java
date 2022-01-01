class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        String log[] =logs.get(0).split(":");
        int[] ans =new int[n];
        int time=0, last=0;
        time =last =Integer.valueOf(log[2]);
        stack.push(Integer.valueOf(log[0]));
        
        
        for(int i=1; i<logs.size(); i++){
            log = logs.get(i).split(":");
            time =Integer.valueOf(log[2]);
            if(log[1].equals("start")){
                if(!stack.isEmpty())ans[stack.peek()] += time-last;
                last =time;
                stack.push(Integer.valueOf(log[0]));
            }else{
                 ans[stack.pop()] += time-last+1;
                last=time+1;
            }
        }
        return ans;
    }
}