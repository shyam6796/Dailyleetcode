class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start =0;
        int end =arr.length-k;
        List<Integer> list = new ArrayList<>();

        while(start <end){
            int mid = start +(end -start)/2;

            if(Math.abs(x -arr[mid]) > Math.abs(arr[mid]-k)){
                start =mid+1;
            }else{
                end =mid;
            }
        }
        for(int i=start; i<start+k; i++){
            list.add(arr[i]);
        }
        return list;
    }
}