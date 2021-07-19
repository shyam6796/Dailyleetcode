class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<2)return;
        int i=nums.length-1,j=nums.length-1,x=0,y=0;
        while(i>0){
            if(nums[i-1]<nums[i])  {
                x=i-1;
                break;
            }
            if(i==1){
                Arrays.sort(nums);
                return;
            }
             i--;
        }
       
        while(j>0){
            if(nums[x]<nums[j]){
                int temp =nums[j];
                nums[j]=nums[x];
                nums[x]=temp;
                break;
            }
            j--;
        }
        List<Integer> list = new ArrayList<>();
        for(int k =x+1; k<nums.length; k++){
            list.add(0,nums[k]);
        }
        for(int k =0; k<list.size(); k++){
            nums[x+k+1]=list.get(k);
        }
    }  
       
}