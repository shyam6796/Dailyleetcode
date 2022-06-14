/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        List<Interval> ans =new ArrayList<>();
        for(List<Interval> li :schedule){
            list.addAll(li);
        }
        Collections.sort(list,(a,b) -> a.start-b.start);
        
        int preStart =list.get(0).start;
        int preEnd =list.get(0).end;
        
        for(int i=1; i<list.size(); i++){
            int currStart = list.get(i).start;        
            int currEnd = list.get(i).end;
            if(list.get(i).start<=preEnd){
               preEnd =Math.max(preEnd, currEnd);
                //continue;
            }else{
                ans.add(new Interval(preEnd,currStart));
                preStart = currStart;
                preEnd = currEnd;
            }
        }
        return ans;
    }
}