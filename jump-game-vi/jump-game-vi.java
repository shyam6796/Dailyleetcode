class Solution {
    public int maxResult(int[] nums, int k) {
        int reuslt=0;
        Deque<Integer> dq = new LinkedList<>();
        int dp[] =new int[nums.length];
        dp[0]=nums[0];
        dq.add(0);
        for(int i=1; i<nums.length; i++){
            
            while(dq.peekFirst() != null  && dq.peekFirst() <i -k){
                    dq.pollFirst();
            }
            dp[i] =dp[dq.peek()] +nums[i];
            
            while(dq.peekFirst() != null  && dp[dq.peekLast()] <= dp[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return dp[dp.length-1];
    }
}