class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(int i =0; i < intervals.length; i++){
            if(!queue.isEmpty() && queue.peek()[1] <=intervals[i][0]){
                int [] curr =queue.poll();
                curr[1] = Math.max(curr[1],intervals[i][1]);
                queue.add(curr);
            }else queue.add(intervals[i]);
        }
        return queue.size();
    }
}