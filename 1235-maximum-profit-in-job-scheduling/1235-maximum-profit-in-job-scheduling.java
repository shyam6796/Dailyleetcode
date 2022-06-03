class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int arr [][] = new int [startTime.length][3];
        TreeMap<Integer,Integer> map =new TreeMap<>();
        map.put(0,0);
        for(int i=0; i<startTime.length; i++){
            arr[i][0]= startTime[i];
            arr[i][1]= endTime[i];
            arr[i][2]= profit[i];
        }
        Arrays.sort(arr,(a,b) -> a[1]- b[1]);
        for(int profits[] : arr){
            int total =map.get(map.floorKey(profits[0])) +profits[2];
            if(map.get(map.lastKey())<total){
                map.put(profits[1],total);
            }
        }
        return map.get(map.lastKey());
    }
}