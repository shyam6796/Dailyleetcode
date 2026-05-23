class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < asteroids.length; i++){
            int a = asteroids[i];
            while(!stack.isEmpty() && stack.peek() > 0 && a <0 ){
               //  System.out.println(stack.peek() +"   "+ a);
                if(Math.abs(stack.peek()) < Math.abs(a)){
                    stack.pop();
                    continue;
                }else if(Math.abs(stack.peek())==Math.abs(a)){
                    stack.pop();
                    a=0;
                    break;
                }
                 a=0;
            }
            if(a!=0)stack.push(a);
           // System.out.println(stack);
        }
        int [] arr =new int[stack.size()];
        int indx =stack.size()-1;
        while(!stack.isEmpty()){
            arr[indx--]=stack.pop();
        }
        return arr;
    }
}