class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals ==null || intervals.length==0)return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]); 
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) -> a[1]-b[1]);
        queue.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++){
            int [] curr= queue.poll();
            if(curr[1]  <= intervals[i][0]){
                curr[1] =intervals[i][1];
            }else{
                queue.add(intervals[i]);
            }
            queue.add(curr);
        }
        return queue.size();
    }
}