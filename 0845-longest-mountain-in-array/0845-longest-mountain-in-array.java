class Solution {
    public int longestMountain(int[] arr) {
        int maxLen =0;
        for(int i=1; i < arr.length-1; i++){
            int left =i-1;
            int right =i+1;
            if(arr[i] <= arr[left] || arr[i] <= arr[right] )continue;

            while(left >=0 && arr[left+1]>arr[left]){
                left--;
            }//left= 0
            while(right <arr.length  && arr[right-1] > arr[right]){
                right++;
            }//right=6
            maxLen =Math.max(maxLen,right-left-1);
            i=right-1;
        }
        return maxLen;
    }
}