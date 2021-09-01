class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n =cars.length;
        double [] ans = new double[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            
            while(!stack.isEmpty() && cars[i][1] <= cars[stack.peek()][1]){
                stack.pop();
            } 
            while(!stack.isEmpty()){
                double temp =(double)(cars[stack.peek()][0] - cars[i][0])/(cars[i][1]- cars[stack.peek()][1]);
                //System.out.println(temp);
                 if(temp <= ans[stack.peek()] || ans[stack.peek()] == -1){
                     ans[i]=temp;
                     break;
                 }
                stack.pop();
            }
           stack.push(i);
        }
        return ans;
    }
}