class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,nums,new ArrayList<>(),new HashSet<>());
        return list;
    }
    public void backtrack(List<List<Integer>> list, int []nums, List<Integer> curr,Set<Integer> set){
        if(curr.size() ==nums.length){
            if(!list.contains(curr))  list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(set.contains(i))continue;
            curr.add(nums[i]);
            set.add(i);
             backtrack(list,nums,curr,set);
             curr.remove(curr.size() - 1);
             set.remove(i);
        }
    }
}