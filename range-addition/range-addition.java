class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] ans = new int [length];
        for(int i=0; i<updates.length; i++){
            int start =updates[i][0];
            int end =updates[i][1];
            int change = updates[i][2];
            for(int j=start; j<=end; j++){
                ans[j] += change;
            }
        }
        return ans;
    }
}