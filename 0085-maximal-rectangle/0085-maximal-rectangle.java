class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea =0;
        int cols [] = new int[n];

        for(int i =0; i <n;i ++){
            cols[i] = matrix[0][i] == '0' ? 0 :1;
        }
        maxArea = helper(cols);

        for(int i =1; i < m; i++){
            for(int j =0; j <n; j++){
                if(matrix[i][j]=='1'){
                    cols[j]++;
                }else cols[j]=0;
            }
            int area = helper(cols);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public int helper(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int area =0;

        for(int i =0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int curr =stack.pop();
                int nextSmall = i;
                int prev = stack.isEmpty() ? -1 : stack.peek();
                int currArea = arr[curr] * (nextSmall -prev -1);
                area =Math.max(area,currArea);
            }
            stack.add(i);
        }
        while(!stack.isEmpty() ){
                int curr =stack.pop();
                int nextSmall = arr.length;
                int prev = stack.isEmpty() ? -1 : stack.peek();
                int currArea = arr[curr] * (nextSmall -prev -1);
                area =Math.max(area,currArea);
        }
        return area;
    }
}