class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int freq=0;

        for(int i=0; i < nums.length; i++){
            sum +=nums[i];
            sum = sum %k;
            if(sum < 0) sum +=k;
            if(map.containsKey(sum)){
                freq +=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return freq;
    }
}