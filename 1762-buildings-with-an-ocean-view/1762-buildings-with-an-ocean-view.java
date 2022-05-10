class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack =new Stack<>();
        for(int i=heights.length-1; i>=0; i--){
            if(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                continue;
            }else{
                stack.push(i);
            }
        }
        int ans[] =new int[stack.size()];
        int index=0;
        while(!stack.isEmpty()){
            ans[index++] =stack.pop();
        }
        return ans;
    }
}