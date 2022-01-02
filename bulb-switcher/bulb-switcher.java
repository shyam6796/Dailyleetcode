class Solution {
    public int bulbSwitch(int n) {
        int count=0;
        for(int num=1; num*num<=n;num++){
            count++;
        }
        return count;
    }
}