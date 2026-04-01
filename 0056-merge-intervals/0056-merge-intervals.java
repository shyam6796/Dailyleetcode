class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        for(int i=0; i < intervals.length; i++){
            int j =list.size()-1;
            if(!list.isEmpty() && list.get(j)[1] >=intervals[i][0]){
                list.get(j)[1] =Math.max(list.get(j)[1],intervals[i][1]);
            }else list.add(intervals[i]);
        }

        return list.toArray(new int[list.size()][2]);
    }
}