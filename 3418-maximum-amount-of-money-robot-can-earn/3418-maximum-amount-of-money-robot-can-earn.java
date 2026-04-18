class Solution {
    Integer memo[][][];
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        memo= new Integer[m][n][3];
       return  helepr(coins,m,n,0,0,2);
    }
    public int helepr(int coins[][],int m, int n, int i, int j, int power){
        if(i==m-1 && j ==n-1){
           if(coins[i][j] < 0 && power >0)return 0;
           return coins[i][j];
        }
        if(i >=coins.length || j >=coins[0].length)return Integer.MIN_VALUE;
        if(memo[i][j][power] !=null)return memo[i][j][power];
      
        int take = coins[i][j] + Math.max(helepr(coins,m,n, i+1, j, power),helepr(coins,m,n, i, j+1, power));

        int skip =Integer.MIN_VALUE;
        if(coins[i][j] < 0 && power >0){
            skip = Math.max(helepr(coins,m,n, i+1, j, power-1),helepr(coins,m,n, i, j+1, power-1));
        }

        return memo[i][j][power] = Math.max(take,skip);
    }
}