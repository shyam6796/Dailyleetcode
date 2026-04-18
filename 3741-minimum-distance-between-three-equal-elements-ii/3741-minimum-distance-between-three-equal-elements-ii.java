class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> map =new HashMap<>();

        for(int i =0; i < nums.length; i++){
           if(!map.containsKey(nums[i]))map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size() >=3){
                 List<Integer> ls = map.get(nums[i]);
                 int a =ls.get(ls.size()-1);
                 int b =ls.get(ls.size()-3);
                  min = Math.min(min,2*(a-b));
            }
        }
      //  System.out.println(map);
       
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}