class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen =0;
        for(int num : nums)set.add(num);
        int curr=0;
        int count=0;
        for(int num :set){
            if(!set.contains(num-1)){
                curr= num;
                count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                maxLen =Math.max(maxLen,count);
            }
            
        }
        return maxLen;
    }
}