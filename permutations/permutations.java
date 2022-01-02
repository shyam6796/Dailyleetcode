class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,list,new ArrayList<>());
        return list;
    }
    
    public void helper(int[] nums, List<List<Integer>> list, List<Integer> ans){
        if(ans.size() > nums.length){
            return;
        }else if(ans.size() == nums.length){
            list.add(new ArrayList<>(ans));
        }else{
            
            for(int i=0; i<nums.length; i++){
                if(ans.contains(nums[i]))continue;
                ans.add(nums[i]);
                 helper(nums,list,ans);
                 ans.remove(ans.size()-1);
            }
        }
    }
}