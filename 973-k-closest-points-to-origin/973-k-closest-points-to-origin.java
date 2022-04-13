class Solution {
    public int[][] kClosest(int[][] points, int k) {
         return quickSelect(points,k);
    }
    
    public int[][] quickSelect(int[][] points, int k){
        int pivot=points.length;
        int left =0;
        int right =points.length-1;
        while(pivot !=k){
            pivot = partiotion(points,left,right);
            if(pivot >k){
                right =pivot-1;
            }else{
                left =pivot;
            }
        }
        return Arrays.copyOf(points,k);
    }
    
    public int partiotion(int[][] points,int left, int right){
        int [] pivot =choosePivot(points, left, right);
        int pivotDist = dist(pivot);
        while(left <right){
            if(pivotDist <= dist(points[left])){
                int temp [] =points[right];
                points[right] =points[left];
                points[left] =temp;
                right--;
            }else{
                left++;
            }
        }
        if (dist(points[left]) < pivotDist)
            left++;
        
        return left;
    }
    
    public int [] choosePivot(int[][] points, int left, int right){
        return points[left + (right - left) / 2];
    }
    
    public int dist(int [] a){
        return a[0]*a[0] +a[1] *a[1];
    }
}