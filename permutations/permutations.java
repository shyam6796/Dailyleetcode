class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(), nums);
        return list;
    }
    public void helper( List<List<Integer>> list, List<Integer> ans, int [] nums){
        if(ans.size() == nums.length){
            list.add(new ArrayList<>(ans));
        }
        
        for(int i=0; i<nums.length; i++){
            if(ans.contains(nums[i])){
                continue;
            }
            ans.add(nums[i]);
             helper(list,ans, nums);
            ans.remove(ans.size()-1);
        }
    }
}    