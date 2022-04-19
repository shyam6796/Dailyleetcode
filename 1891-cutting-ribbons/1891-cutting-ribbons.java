class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max=0;
        for(int i : ribbons){
            max =Math.max(i,max);
        }
        return binarySearch(ribbons,k,1,max);
    }
    
    public int binarySearch(int[] ribbons, int k, int start, int end){
        if(start>end){
            return  0;
        }
        int mid =start +(end-start)/2;
        boolean flag =helper(ribbons,mid,k);
        if(flag && !helper(ribbons,mid+1,k)){
            return mid;
        }else if(!flag){
            return binarySearch(ribbons,k,start,mid-1);
        }
        return binarySearch(ribbons,k,mid+1,end);
    }
    
    public boolean helper(int[] ribbons,int cuts,int k){
        int sum=0;
        for(int ribbon :ribbons){
            sum += ribbon/cuts;
        }
        return sum >=k;
    }
}