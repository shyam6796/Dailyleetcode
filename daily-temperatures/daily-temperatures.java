class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> stack = new Stack<>();
    int n = temperatures.length;
    int[] ans = new int[n];
    for(int i = n-1; i >= 0; i--){
        if(stack.isEmpty()){
            stack.push(i);
            ans[i]=0;
        }else{
            if(temperatures[i] < temperatures[stack.peek()]){
                ans[i]=stack.peek()-i;
                stack.push(i);
            }
            if(temperatures[i] >= temperatures[stack.peek()]){
                while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                    stack.pop();
                }
                if(!stack.isEmpty())ans[i]=stack.peek()-i;
                else ans[i]=0;
                stack.push(i);
            }
        }
    }
    
    return ans;
}
}