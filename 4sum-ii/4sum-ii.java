class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int ans=0;
        for(int a : nums1){
            for(int b : nums2){
                map.put(a+b, map.getOrDefault(a+b,0)+1);
            }
        }
         for(int i : nums3){
            for(int j : nums4){
                ans +=map.getOrDefault(-(i+j),0);
                }       
            }
         
        return ans;
    }
}