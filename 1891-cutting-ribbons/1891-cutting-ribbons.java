class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max =Integer.MIN_VALUE ;
        for(int i :ribbons)max=Math.max(max,i);
        return BinarySeach(ribbons,k,1,max);
    }
    public int BinarySeach(int[] ribbons, int k,int min, int max){
        if(min> max)return 0;
            int mid = min+(max-min)/2;
            boolean flag =helper(ribbons,k,mid);
            if(flag && !helper(ribbons,k,mid+1)) return mid;
        if(!flag){
            return BinarySeach(ribbons,k, min,mid-1);
        }else{
             return BinarySeach(ribbons,k, mid+1,max);
        }
        
    }
    public boolean helper(int[] ribbons, int k,int size){
        int count=0;
        for(int ribbon : ribbons){
            
            count += (ribbon/size);
        }
        
        return count >= k;
    }
}