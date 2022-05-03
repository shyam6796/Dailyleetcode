class Solution {
    public double angleClock(int hour, int minutes) {
            double hr = (hour +minutes/60.0)*30;
            double min =minutes*6;
            double ans =Math.abs(hr -min);
        
        return ans <=180 ? ans : 360-ans;
    }
}