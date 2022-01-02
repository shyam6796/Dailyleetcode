class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] temp = new int[intervals.length+1][2];
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++){
            temp[i]= intervals[i];
        }
        temp[intervals.length] =newInterval;
        Arrays.sort(temp, (a,b) -> a[0] -b[0]);
        
        for(int i [] : temp){
            if(list.size() ==0 || list.get(list.size() -1)[1] <i[0]){
                list.add(i);
            }else{
                list.get(list.size() -1)[1] = Math.max(list.get(list.size() -1)[1],i[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}