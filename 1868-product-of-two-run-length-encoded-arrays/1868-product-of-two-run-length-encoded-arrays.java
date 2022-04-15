class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int m =encoded1.length;
        int n =encoded2.length;
        int i=0,j=0;
        
        while(i<m && j<n){
            int product = encoded1[i][0] *encoded2[j][0];
            int freq = Math.min(encoded1[i][1],encoded2[j][1]);
            
            if(result.isEmpty() || result.get(result.size()-1).get(0) != product){
                List<Integer> list =new ArrayList<>();
                list.add(product);
                list.add(freq);
                result.add(list);
            }else{
               List<Integer> list =result.get(result.size()-1);
                list.set(1,list.get(1)+freq);
                result.set(result.size()-1,list);
            }
            
            encoded1[i][1] -=freq;
            encoded2[j][1] -=freq;
            
            if(encoded1[i][1] ==0)i++;
            if(encoded2[j][1]==0)j++;
            
        }
        return result;
        
    }
}