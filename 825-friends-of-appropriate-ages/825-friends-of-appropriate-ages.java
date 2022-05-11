class Solution {
    public int numFriendRequests(int[] ages) {
        int age[] =new int[121];
        
        for(int i=0; i<ages.length; i++){
            age[ages[i]]++;
        }
        
        
        int ans=0;
        
        for(int a =0; a<=120; a++){
            for(int b = (int) (0.5 *a) +8;  b<=a; b++){
                ans += age[b]*age[a];
            if(b==a){
                ans -=age[a];
            }
            }
        }
        
        return ans;
    }
}