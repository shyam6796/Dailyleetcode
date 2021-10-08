class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stack = new Stack<>();
         boolean blows = false;
        for(int asteroid : asteroids){
            blows = false;
            while(!stack.isEmpty() && asteroid <0  &&  stack.peek()>0 && !blows){
                if(stack.peek() >-asteroid){
                    blows = true;
                    continue;
                }else if(stack.peek() == -asteroid){
                    stack.pop();
                    blows = true;
                }else{
                     stack.pop();
                }
                
            }
            if(!blows)    
            stack.push(asteroid);
        }
        
        int[] result = new int[stack.size()];
        for(int i=result.length-1 ; i>=0 ;i--)
        {
            result[i] = stack.pop();
        }
        
        return result;
    }
}