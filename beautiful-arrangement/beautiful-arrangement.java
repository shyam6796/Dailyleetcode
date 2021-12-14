class Solution {
    int count =0;
    public int countArrangement(int n) {
        boolean arr[] = new boolean[n+1];
        helper(arr,1,n);
        return count;
    }
    
    public void helper(boolean arr[], int pos, int n){
        if(pos >n){
            count++;
            
        }
        
        for(int i=1; i<=n; i++){
            if(!arr[i] && (pos%i ==0 || i%pos ==0 )){
                arr[i] =true;
                helper(arr,pos+1,n);
                arr[i] =false;
            }
        }
    }
}