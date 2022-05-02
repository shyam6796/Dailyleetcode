class Solution {
    public int minTimeToType(String s) {
        int time=0;
        for(int i=1; i<s.length(); i++){
            int x=(s.charAt(i-1) -'a');
            int y=(s.charAt(i) -'a');
            int diff =Math.abs(x-y);
            
            time += Math.min(diff,26-diff);
            System.out.println(diff+ "  "+ time);
        
        }
        if(s.charAt(0) !='a'){
            int x=(s.charAt(0) -'a');
            time += Math.min(x,26-x);
        }
        return time+s.length();
    }
}