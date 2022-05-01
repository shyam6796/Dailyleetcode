class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelct(points, k);
    }
    
    public int[][] quickSelct(int[][] points, int k){
        int left=0;
        int right=points.length-1;
        int pivot_index =right+1;
        
        while(k !=pivot_index){
            pivot_index =partiton(points,left,right);
            
            if(pivot_index >k){
                right =pivot_index-1;
            }else{
                left =pivot_index;
            }
        }
        return Arrays.copyOf(points,k);
    }
    
    public int partiton(int[][] points, int left, int right){
        int pivot[] = points[left +(right-left)/2];
        int pivot_dist =dist(pivot);
        while(left<=right){
            if(pivot_dist <= dist(points[left])){
                int temp[] =points[left];
                points[left]=points[right];
                points[right]=temp;
                right--;
            }else{
                left++;
            }
        }
        
        
        return left;
        
    }
    
    public int dist(int a[]){
        return a[0]*a[0] +a[1]*a[1];
    }
}