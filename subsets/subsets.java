class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,ans,0,new ArrayList<>());
        return ans;
    }
    public void helper(int [] nums,List<List<Integer>> ans, int index, List<Integer> list){
        
        if(!ans.contains(list)){
            ans.add(new ArrayList<>(list));
        }
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
             helper(nums,ans,i+1,list);
            list.remove(list.size()-1);
        }
    }
}