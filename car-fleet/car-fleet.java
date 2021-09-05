class Solution {
    public int carFleet(int target, int[] positions, int[] speeds) {
        int cars[][] = new int[positions.length][2];
        double preArrivleTime =Integer.MIN_VALUE;
        int fleets =0;
        for(int i = 0; i < speeds.length; i++){
           cars[i][0]=positions[i];
           cars[i][1]=speeds[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0],a[0]));
        for(int i = 0; i<cars.length; i++){
            double arrivleTime =(double)(target - cars[i][0])/cars[i][1];
            if(arrivleTime > preArrivleTime){
                fleets++;
                preArrivleTime =arrivleTime;
            }
        }
        return fleets;
        
    }
}