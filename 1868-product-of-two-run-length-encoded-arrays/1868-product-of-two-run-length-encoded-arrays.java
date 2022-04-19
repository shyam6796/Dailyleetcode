class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> list =new ArrayList<>();
        int i=0, j=0;
        int m =encoded1.length;
        int n =encoded2.length;
        while(i <m && j <n){
            int product = encoded1[i][0] *encoded2[j][0];
            int freq = Math.min(encoded1[i][1],encoded2[j][1]);
            
            if(list.isEmpty() || list.get(list.size()-1).get(0) !=product){
                List<Integer> ans =new ArrayList<>();
                ans.add(product);
                ans.add(freq);
                list.add(ans);
            }else{
                List<Integer> temp =list.get(list.size()-1);
                temp.set(1,temp.get(1) +freq);
                list.set(list.size()-1, temp);
            }
            encoded1[i][1] -=freq;
            encoded2[j][1] -=freq;
            if( encoded1[i][1] ==0) i++;
            if( encoded2[j][1] ==0) j++;
        }
        
        return list;
    }
}