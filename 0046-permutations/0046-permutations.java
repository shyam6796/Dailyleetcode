class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,nums,new ArrayList<>());
        return list;
    }
    public void helper (List<List<Integer>> list, int nums[], List<Integer> ans){
        if(ans.size() ==nums.length){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i =0; i < nums.length; i++){
            if(ans.contains(nums[i]))continue;
            ans.add(nums[i]);
            helper(list, nums, ans);
            ans.remove(ans.size()-1);
        }
    }
}