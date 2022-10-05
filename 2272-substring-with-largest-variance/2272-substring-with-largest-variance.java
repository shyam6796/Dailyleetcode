class Solution {
    public int largestVariance(String s) {
       HashMap<Character,Integer> map =new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int variance=0;
        
        for(char c1 :map.keySet()){
            for(char c2 :map.keySet()){
                if(c1==c2){
                    continue;
                }
                int c1freq=0, c2freq=0;
                int c1rem =map.get(c1);
                for(char c :s.toCharArray()){
                    if(c==c1){
                        c1freq++;
                        c1rem--;
                    }
                    if(c==c2){
                        c2freq++;
                    }
                    
                    if(c1freq >c2freq && c1rem >0){
                        c1freq=0;
                        c2freq=0;
                    }
                    if(c1freq >0 && c2freq >0){
                        variance =Math.max(variance,c2freq-c1freq);
                    }
                }
            }
        }
        return variance;
    }
}