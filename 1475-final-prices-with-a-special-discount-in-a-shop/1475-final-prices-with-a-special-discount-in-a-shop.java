class Solution {
    public int[] finalPrices(int[] prices) {
        int ans [] = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                 ans[stack.peek()] = prices[stack.pop()] -prices[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.peek()] =prices[stack.pop()];
        }
        return ans;
    }
}