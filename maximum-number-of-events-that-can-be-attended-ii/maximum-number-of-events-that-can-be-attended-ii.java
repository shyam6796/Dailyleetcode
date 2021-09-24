class Solution {
    public int maxValue(int[][] events, int k) {
            int [][] memo = new int [k+1][events.length];
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        return dfs(events,k,0, memo);
    }
    
    public int dfs(int[][] events, int k, int idx, int [][] memo){

        int ret =0;
        if(k==1){
             while(idx <events.length) ret= Math.max(ret,events[idx++][2]);
            return ret;
        }
        if(memo[k][idx] !=0)return memo[k][idx];
        
        for(int i=idx; i<events.length; i++){
            int val = events[i][2];
            for(int j=i+1; j<events.length; j++){
                if(events[j][0] > events[i][1])
                ret = Math.max(ret, val+ dfs(events,k-1,j, memo));
            }
            ret =Math.max(ret,val);
        }
        return memo[k][idx] =ret;
    }
}