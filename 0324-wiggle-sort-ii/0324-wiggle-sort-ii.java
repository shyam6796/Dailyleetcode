class Solution {
    public void wiggleSort(int[] nums) {
       Arrays.sort(nums);
       int right =nums.length-1;
       int left =0;
       int arr[] =new int[nums.length];
        int i =1;

        while(i < arr.length){
            arr[i] =nums[right];
            right--;
            i +=2;
        } 
        i=0;
        while(i < arr.length){
            arr[i] =nums[right];
            right--;
            i +=2;
        }

        for( i =0; i < nums.length; i++){
            nums[i] =arr[i];
        }
    }
}