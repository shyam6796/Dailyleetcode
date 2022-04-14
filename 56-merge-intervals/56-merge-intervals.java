class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> {
           if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int [] interval : intervals){
            if(!list.isEmpty() && list.get(list.size() -1)[1] >=interval[0]){
               list.get(list.size() -1)[1] = Math.max(list.get(list.size() -1)[1],interval[1]);
            }else{
                list.add(interval);
            }
        }
        return list.toArray(new int [list.size()][2]);
    }
}