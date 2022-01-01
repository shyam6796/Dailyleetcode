class Solution {
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(n<=3) return list;
       
        helper(n,2,list, new ArrayList<>());
        
        return list; 
    }
    
    public void  helper(int n, int factor,List<List<Integer>> list, List<Integer> ans){
        
        for(int i= factor; i*i<=n; i++){
            if(n%i !=0){
                continue;
            }
            
            ans.add(i);
            List<Integer> temp = new ArrayList<>(ans);
            temp.add(n/i);
            list.add(temp);
            
            if(i*i <= n/i){
                helper(n/i, i, list,ans);
            }
            ans.remove(ans.size()-1);
        }
        
    }
}