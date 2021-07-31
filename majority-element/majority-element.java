class Solution {
    public int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }else {
                counts.put(num, counts.get(num)+1);
            }
        }
        System.out.println(counts);
        int max =nums[0];
        for(int i : counts.keySet()){
            if(counts.get(i)>counts.get(max)){
                max=i;
            }
        }
        return max;
}
}