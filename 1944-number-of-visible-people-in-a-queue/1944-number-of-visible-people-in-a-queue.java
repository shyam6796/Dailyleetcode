class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];
        
        for (int i = heights.length - 1; i >= 0; i--) {
            // Keep the heights sorted in decreasing order. 
            while (!stack.empty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                result[i]++;
            }
            
            if (!stack.isEmpty()) {
                result[i]++;
            }
            
            stack.push(i);
        }
        
        return result;
    
    }
}