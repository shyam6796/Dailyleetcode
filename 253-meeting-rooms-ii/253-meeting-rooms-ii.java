class Solution {
    public int minMeetingRooms(int[][] intervals) {
       if(intervals ==null || intervals.length==0)return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        PriorityQueue<int[]>  PQ = new PriorityQueue<int[]>((a,b) -> a[1] -b[1]);
        PQ.add(intervals[0]);
       // System.out.println(PQ);
        for(int i=1; i<intervals.length; i++){
            int[] current =PQ.poll();
            int[] next=intervals[i];
            if(current[1] <=next[0]){
                current[1]=next[1];
            }else{
                PQ.add(next);
            }
            PQ.add(current);
            System.out.println(PQ);
        }
        return PQ.size();
    }
}