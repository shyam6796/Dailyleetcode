class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans =new ArrayList<>();
        
        for(int i = 0; i < numRows; i++){
            List<Integer> temp =new ArrayList<>();
            
            if(i == 0){
                temp.add(1);
               // ans.add(temp);
            }else if(i == 1){
                temp.add(1);
                temp.add(1);
                //ans.add(temp);
            }else{
                
                temp.add(1);
                for(int j = 1; j<i; j++){
                    temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
                temp.add(1);
                
            }
                ans.add(temp);
        }
       return ans;     
        
        
    }
}