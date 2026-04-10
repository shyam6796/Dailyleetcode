class Solution {
    Integer memo[] ;
    public int minCostClimbingStairs(int[] cost) {
        memo =new Integer[cost.length];
        return Math.min(helper(cost,0),helper(cost, 1));
    }
    public int helper(int[]cost, int index){
        if(index >=cost.length)return 0;

        if(memo[index] !=null)return memo[index];
        int b =cost[index] +helper(cost, index+2);
        int a = cost[index] +helper(cost, index+1);
        return memo[index] = Math.min(a,b);
    }
}