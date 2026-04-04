class Solution {
    public int jump(int[] nums) {
        int jumps =0;
        int farthest =0;
        int curr =0;

        for(int i=0; i < nums.length-1; i++){
            if(farthest < i+nums[i]){
                farthest =nums[i] +i;
            }
            if(curr ==i){
                jumps++;
                curr= farthest;
            }
        }
        return jumps;
    }
}