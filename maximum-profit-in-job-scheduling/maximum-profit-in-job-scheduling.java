class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] dp=new int[n][3];
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for(int i=0; i<n; i++){
            dp[i][0]=startTime[i];
            dp[i][1]=endTime[i];
            dp[i][2]=profit[i];
        }
        Arrays.sort(dp, (a,b) -> a[1]-b[1]);
        map.put(0,0);
        for(int curr[] : dp){
            int profits = map.floorEntry(curr[0]).getValue() +curr[2];
            if(map.lastEntry().getValue()< profits){
                map.put(curr[1],profits);
            }
        }
        
        return map.lastEntry().getValue();
    }
}