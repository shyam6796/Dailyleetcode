class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points,k);
    }
    
    public int[][] quickSelect(int[][] points, int k) {
        int left=0;
        int right=points.length-1;
        int pivot =points.length;
        while(pivot !=k){
            pivot =partiotion(points,left,right);
            if(pivot >k){
                right =pivot-1;
            }else{
                left =pivot;
            }
        }
        
        return Arrays.copyOf(points,k);
    }
    
    public int partiotion(int points[][],  int left, int right){
        int pivot[] =points[left + (right - left) / 2];
        int pivot_dist= dist(pivot);
        while(left<right){
            if(pivot_dist <= dist(points[left])){
                int temp[] =points[left];
                points[left]=points[right];
                points[right]=temp;
                right--;
            }else{
                left++;
            }
        }
        if (dist(points[left]) < pivot_dist)
            left++;
        
        return left;
    }
    
    public int dist(int a[]){
        return a[0]*a[0] +a[1]*a[1];
    }
}