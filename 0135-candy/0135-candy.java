class Solution {
    public int candy(int[] ratings) {
        int ans =1;
        int i=1;
        
        while(i < ratings.length){
            if(ratings[i]==ratings[i-1]){
                ans++;
                i++;
                continue;
            }
            int up=1;
            while(i < ratings.length && ratings[i] > ratings[i-1]){
                up++;
                ans +=up;
                i++;
            }

            int down =1;
            while(i < ratings.length && ratings[i-1] > ratings[i]){
                ans +=down;
                down++;
                i++;
            }
            if(down - up >0)ans +=down -up;

        }
        return ans;
    }
}