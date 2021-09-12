class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) ->b[1]-a[1]);
        int ans=0;
        for(int [] box : boxTypes){
            if(truckSize <= 0)break;
            if(box[0]<=truckSize){
                ans += box[0]*box[1];
                truckSize -=box[0];
            }else if(truckSize < box[0]){
                ans += truckSize*box[1];
                truckSize=0;
            }
        }
        return ans;
    }
}