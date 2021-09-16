class Solution {
    public int maxEvents(int[][] events) {
        if(events.length ==0 ||events == null )return 0;
        Arrays.sort(events,(a,b) -> {
           if(a[1]==b[1])return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        int ans=0;
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int []event : events){
            min = Math.min(event[0],min);
            max = Math.max(event[1],max);
        }
        
        for(int i=min; i<=max; i++){
            set.add(i);
        }
        
        for(int[] event : events){
            if(set.contains(event[0])){
                ans++;
                set.remove(event[0]);
            }else{
                Integer nextPossibleDay =set.ceiling(event[0]);
                if(nextPossibleDay!= null &&  nextPossibleDay<=event[1]){
                    ans++;
                     set.remove(nextPossibleDay);
                }
            }
        }
        return ans;
    }
}