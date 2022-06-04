class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index=-1;
        int dist=Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++){
            if(points[i][0]==x || points[i][1] ==y){
               if(points[i][0]==x && points[i][1] ==y) return i;  
              int tempDist =Math.abs(points[i][0]-x) + Math.abs(points[i][1]-y);
                 if(tempDist <dist){
                    dist =tempDist;
                    index=i;
                }
            }
        }
            
        return index;
    }
}