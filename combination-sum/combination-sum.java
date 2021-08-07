class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(candidates,target,list,0,ans,0);
        // for(int i =0; i<ans.size(); i++){
        //     System.out.println(ans.get(i));
        // } 
        return list;
    }
    public void helper(int[] candidates,int target, List<List<Integer>> list, int total, List<Integer> ans, int index){
            if(total>target){
                return;
            }
            else if(total== target){
                
                list.add(new ArrayList<>(ans));
                return;
            }    
             else if(total<target){
                for(int i =index; i<candidates.length; i++){
                 ans.add(candidates[i]);
               helper(candidates, target, list, total+candidates[i],ans,i);
                ans.remove(ans.size()-1);
               }
            }                
    }  
}