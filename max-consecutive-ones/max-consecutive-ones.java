class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int sum =0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]== 0){
                    sum=0;
                }else{
                    sum++;
                    max =Math.max(sum,max);
                }
            }
        return max;
    }
}