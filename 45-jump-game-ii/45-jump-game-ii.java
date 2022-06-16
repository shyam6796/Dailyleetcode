class Solution {
    public int jump(int[] nums) {
        int count=0, fatrhest=0, currentJumpEnd=0;
        for(int i=0; i<nums.length-1; i++){
            fatrhest =Math.max(fatrhest,i+nums[i]);
            if(i==currentJumpEnd){
                currentJumpEnd=fatrhest;
                count++;
            }
        }
        return count;
    }
}