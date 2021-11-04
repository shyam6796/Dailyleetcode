class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <3)return points.length;
        
        int pointsOnLine =2;
        
        
        for(int i=0; i<points.length; i++){
            HashMap<String,Integer> map = new HashMap<>();
            for(int j =i+1; j< points.length; j++){
                String s =getSlope(points[i],points[j]);
                map.put(s, map.getOrDefault(s,0)+1);
            }
            for(String s :map.keySet()){
            pointsOnLine =Math.max(pointsOnLine, map.get(s)+1);
            }
        }
        
        
        return pointsOnLine;
    }
    
    public String getSlope(int p1[], int p2[]){
        int x = p1[0]-p2[0];
        int y=  p1[1]-p2[1];
        int gcd =getGcd(x,y);
        
        x =(gcd==0 ? x/ Math.max(x,y) : x/gcd);
        y =(gcd==0 ? y/ Math.max(x,y) : y/gcd);
        
        return "" +x +"_"+ y ;
    }
    public int getGcd(int x, int y){
       return y==0 ? x :getGcd(y,x % y);
    }
}