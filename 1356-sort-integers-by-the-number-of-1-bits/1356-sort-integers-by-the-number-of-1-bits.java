class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for(int i=0; i < arr.length; i++)nums[i] =arr[i];

        Arrays.sort(nums,(a,b)->{
            int x = countNoOfBits(a);
            int y =countNoOfBits(b);
            if(x==y)return Integer.compare(a, b);
            return Integer.compare(x, y);
        });

        for(int i=0; i < arr.length; i++){
            arr[i] =nums[i];
        }
        return arr;
    }
    public int countNoOfBits(int num){
        int count =0;

        while(num !=0){
            count +=num&1;
            num =num >> 1;
        }
        return count;
    }
}