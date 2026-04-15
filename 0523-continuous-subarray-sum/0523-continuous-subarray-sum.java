class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(0,0);

        for(int i=0; i < nums.length; i++){
            sum +=nums[i];
            sum =sum%k;
            if(map.containsKey(sum) && map.get(sum) !=i){
                return true;
            }

             map.put(sum,i);
        }
        return false;
    }
}