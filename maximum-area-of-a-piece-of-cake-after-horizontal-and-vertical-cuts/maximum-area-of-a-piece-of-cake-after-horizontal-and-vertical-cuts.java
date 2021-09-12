class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxH =(long)helper(horizontalCuts,h);
        long maxW= (long)helper(verticalCuts,w);
        long ans =(maxH * maxW);
        long mod =(ans) %1000000007L;
                        
        return (int)mod;
    }
    public int helper(int[] Cuts, int n){
        Arrays.sort(Cuts);
         int max =Cuts[0];
        for(int i=1; i<Cuts.length; i++){
            max=Math.max(max,Cuts[i]-Cuts[i-1]);
        }
        return Math.max(max, n-Cuts[Cuts.length-1]);
    }
}