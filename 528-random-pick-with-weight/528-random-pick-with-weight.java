class Solution {
    int sum =0;
    int nums[];
    public Solution(int[] w) {
        nums= new int[w.length];
        for(int i=0; i<w.length; i++){
            sum+=w[i];
            nums[i] =sum;
        }
    }
    
    public int pickIndex() {
        Random rand =new Random();
        int index =rand.nextInt(sum);
        for(int i=0; i<nums.length; i++){
            if(nums[i] >index){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */