class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list =new ArrayList<>();
        //list.add(new ArrayList<>());
        Arrays.sort(arr);
        int diff =Integer.MAX_VALUE;

        for(int i=1; i < arr.length;i++){ 
            if(diff== (arr[i]-arr[i-1])){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                list.add(temp);
            }else if(diff >arr[i] -arr[i-1]){
               list.clear();
               List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                list.add(temp); 
                diff = arr[i]-arr[i-1];
        }
            }
             

       
        return list;
    }
}