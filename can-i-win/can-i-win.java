class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >desiredTotal)return true;
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) /2;
        if(sum < desiredTotal){
            return false;
        }
        
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return canWin(maxChoosableInteger, 0, desiredTotal, used, cache,0);
    }
    
    public boolean canWin(int maxChoosableInteger, int runningTotal, int desiredTotal,  boolean[] used,HashMap<Integer, Boolean> cache,int bitMap){
        
        if(runningTotal >=desiredTotal){
            return false;
        }else{
            if(cache.containsKey(bitMap)){
                return cache.get(bitMap);
            }
            boolean staus=false;
            for(int i=1; i<=maxChoosableInteger; i++){
                if(!used[i]){
                    
                    used[i] = true;
                    staus = !canWin(maxChoosableInteger,runningTotal+i, desiredTotal, used, cache, (1<<i) | bitMap);
                    used[i] = false;
                }
                if(staus) break;
            }
            cache.put(bitMap,staus);
            return staus;
        }
        
    }
}