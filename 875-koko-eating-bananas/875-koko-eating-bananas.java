class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=1;
        for(int i :piles){
           end= Math.max(i,end);
            
        }
        int ans=0;
        while(start<end){
            int mid =start +(end-start)/2;
            int sum=0;
            
           
            for (int pile : piles) {
                sum += pile/mid;
                if(pile%mid >0) sum++;
               
            }
           
           // System.out.println();
            //if(sum==h)return mid;
            if(sum >h){
                start =mid+1;
            }else{
                end =mid;
            }
        }
        return end;
    }
}