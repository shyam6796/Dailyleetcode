class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,list,new HashSet<>(),new ArrayList<>(),0);
        return list;
    }
    public void helper(int []nums,List<List<Integer>> list, Set<Integer> set, List<Integer> ans, int index){
         if(index > nums.length)return;
        if(!list.contains(ans))list.add(new ArrayList<>(ans));

        for(int i =index; i <nums.length; i++){
            ans.add(nums[i]);
            helper(nums, list, set, ans, i+1);
            ans.remove(ans.size()-1);
        }
    }
}