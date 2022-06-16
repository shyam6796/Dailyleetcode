class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0, minprice= prices[0];
        for( int i = 1 ; i < prices.length; i++){
                if(prices[i] < minprice){
                    minprice =prices[i];
                }else if(prices[i]- minprice > maxP){
                    maxP = prices[i] - minprice;
                }
        }
        return maxP;
    }
}