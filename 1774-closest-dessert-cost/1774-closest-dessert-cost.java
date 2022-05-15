class Solution 
{
    int closCost = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int baseCost :baseCosts){
            helper(toppingCosts,0,baseCost, target);
        }
        return closCost;
    }
    
    public void helper(int[] toppingCosts, int currIndex, int currCost, int targert){
        if(Math.abs(targert-currCost) <Math.abs(targert-closCost)){
            closCost =currCost;
        }
        if(Math.abs(targert-currCost) ==Math.abs(targert-closCost)){
            closCost =Math.min(closCost,currCost);
        }
        
        if(currCost<=targert &&   currIndex < toppingCosts.length){
           helper(toppingCosts,currIndex+1,currCost, targert); 
           helper(toppingCosts,currIndex+1,currCost +toppingCosts[currIndex], targert); 
           helper(toppingCosts,currIndex+1,currCost + 2*toppingCosts[currIndex], targert);  
        }
    }
}