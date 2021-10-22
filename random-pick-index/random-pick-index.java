class Solution {
    HashMap<Integer,List<Integer>> map =new HashMap<>();
    public Solution(int[] nums) {
        for(int i=0; i< nums.length; i++){
            map.put(nums[i],new ArrayList<Integer>());
        }
        for(int i=0; i< nums.length; i++){
          map.get(nums[i]).add(i);
        }
        System.out.println(map);
    }
    
    public int pick(int target) {
        Random rand =new Random();
        List<Integer> temp =map.get(target);
        int i = rand.nextInt(temp.size());
        return temp.get(i);
       
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */