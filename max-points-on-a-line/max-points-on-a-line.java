class Solution {
    public int maxPoints(int[][] points) {
        int max=1;
        
        for(int i=0; i<points.length; i++){
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=i+1; j<points.length; j++){
                String slope =getSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope,0)+1);
            }
            for(String s :map.keySet()){
                max =Math.max(max, map.get(s)+1);
            }
        }
        return max;
    }
    
    public String getSlope(int a[], int b[]){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        int gcd = getGCD(x,y); 
        x = (gcd ==0 ? x/Math.max(x,y) : x/gcd);
        y = (gcd ==0 ? y/Math.max(x,y) : y/gcd);
        
        return "" +x +"_" +y;
    }
    
    public int getGCD(int x ,int y){
        return y==0 ? x : getGCD(y,x % y) ;
    }
}