class Solution {
    public int largestRectangleArea(int[] heights) {
       int maxArea =0;
       Stack<Integer> stack = new Stack<>();

       for(int i =0 ; i < heights.length; i++){
            while(!stack.isEmpty() &&  heights[stack.peek()] >heights[i]){
                int curr =stack.pop();
                int nextSmall = i;
                int prevSmall = stack.isEmpty() ? -1 : stack.peek();

                int area = heights[curr] * (nextSmall -prevSmall-1);
                maxArea =Math.max(area,maxArea);
            }
            stack.add(i);
       } 

       while(!stack.isEmpty()){
                int curr =stack.pop();
                int nextSmall = heights.length;
                int prevSmall = stack.isEmpty() ? -1 : stack.peek();

                int area = heights[curr] * (nextSmall -prevSmall-1);
                maxArea =Math.max(area,maxArea);
        }

        return maxArea;
    }
}