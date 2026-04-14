class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set =new HashSet();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
           
            for(int j=i+1; j < nums.length; j++){
                 int sum =-nums[i] -nums[j];
                 if(map.containsKey(sum) && map.get(sum) == i){
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);
                    Collections.sort(list);
                    set.add(list);
                 }
                 map.put((nums[j]),i);
            }
        }
        return new ArrayList<>(set);
        
    }
}