class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
       helper(list,nums,new ArrayList(),0);
       return list;
    }
    public void helper(List<List<Integer>> list, int []nums,List<Integer>ans,int index){
       if(index > nums.length)return;
        list.add(new ArrayList<>(ans));

        for(int i =index; i <nums.length; i++){
            ans.add(nums[i]);
            helper(list, nums, ans, i+1);
            ans.remove(ans.size()-1);
        }
    
    }
}