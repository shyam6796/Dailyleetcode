class Solution {
    public int reversePairs(int[] nums) {
        
        return divide(nums, 0 ,nums.length-1);
    }
    
    public int divide(int arr[], int l, int r){
        int count =0;
        if(l<r){
            int mid = l+ (r-l) / 2;
           count+= divide (arr, l,mid);
           count+=divide (arr, mid+1,r);
         count+= merge(arr,l,mid,r);
        }
        return count;
    }
    
    public int merge(int arr[], int l, int mid, int r){
        int left =mid -l+1, right =r -mid;
        int leftArr [] = new int [left];
        int rightArr [] = new int [right];
        
        for(int i=0; i<left; i++) leftArr[i] = arr[l + i];
        for(int i=0; i<right; i++) rightArr[i] = arr[mid + 1 + i];
        
        int k=left, i=0,j=0, cnt =0;
        
        while(i< left && j <right){
            if(leftArr[i] > ( (long) rightArr[j])* 2){
                cnt += leftArr.length -i;
                j++;
            }else{
                i++;
            }
        }
        i = 0; j = 0; k = l;
          while(i< left && j <right){
              if(leftArr[i] <= rightArr[j]){
                  arr[k++]=leftArr[i++];
              }else{
                   arr[k++]=rightArr[j++];
              }
          }
        
        while(i <left) arr[k++]=leftArr[i++];
        while(j<right) arr[k++]=rightArr[j++];
        
        return cnt;
        
    }
}