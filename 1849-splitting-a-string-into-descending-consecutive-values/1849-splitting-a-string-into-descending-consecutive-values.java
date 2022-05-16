class Solution {
    public boolean splitString(String s) {
        return solve(0,-1,s,0);
    }
    public boolean solve(int index, long prev, String s,int k){
        if(index ==s.length()){
            return k>=2;
        }
        long curr=0;
        for(int i =index; i<s.length(); i++){
            curr = curr*10 +s.charAt(i) -'0';
            if((prev ==-1 || prev-curr ==1) && solve(i+1,curr,s,k+1)) return true;
        }
        return false;
    }
}