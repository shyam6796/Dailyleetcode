class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
       
        for(int i=arr.length-1; i>0; i--){
            for(int j=1; j<=i; j++){
                if(arr[j]==i+1){
                    filp(arr,j);
                    list.add(j+1);
                }
            }
            filp(arr,i);
            list.add(i+1);
        }
        return list;
    }
    public void filp(int [] a, int n){
        for(int i=0; i<=n/2; i++){
            int temp =a[i];
            a[i]=a[n-i];
            a[n-i]=temp;
        }
    }

}