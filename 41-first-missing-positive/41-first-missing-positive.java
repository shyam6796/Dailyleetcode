class Solution {
    public int firstMissingPositive(int[] nums) {
         long max=1;
        HashSet<Integer> map=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.add(nums[i]);
            max=Math.max(max,nums[i]);
        }
        int res=0;
        for(int i=1; i<=max+1;i++){
            if(!map.contains(i)){
                res=i;
                break;
            }
        }
        return res;
    }
}