class Solution {
    public int maximumSwap(int num) {
        char nums[] = String.valueOf(num).toCharArray();
        int maps[] =new int[10];
        for(int i=0; i<nums.length; i++){
            maps[nums[i]-'0']=i;
        }
        
        for(int i=0; i<nums.length; i++){
            int curr= nums[i]-'0';
            for(int j=9; j>curr; j--){
                if(i< maps[j]){
                    char temp =nums[i];
                    nums[i] = nums[maps[j]];
                    nums[maps[j]]=temp;
                    
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}