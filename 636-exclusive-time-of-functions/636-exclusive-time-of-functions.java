class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        String log[] =logs.get(0).split(":");
        int time =Integer.valueOf(log[2]);
        int last=time;
        int id =Integer.valueOf(log[0]);
        stack.add(id);
        
        for(int i=1; i<logs.size(); i++){
            log =logs.get(i).split(":");
            time =Integer.valueOf(log[2]);
            id =Integer.valueOf(log[0]);
            
            if(log[1].equals("start")){
                if(!stack.isEmpty())ans[stack.peek()] += time -last;
                last=time;
                stack.push(id);
            }else{
                if(!stack.isEmpty())ans[stack.pop()] += time-last+1;
                last =time+1;
            }
        }
        return ans;
    }
}