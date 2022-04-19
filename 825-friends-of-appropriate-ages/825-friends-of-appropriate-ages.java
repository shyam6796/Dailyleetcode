class Solution {
    public int numFriendRequests(int[] ages) {
        int arr[] =new int[121];
        for(int age :ages){
            arr[age]++;
        }
        int count =0;
        
        for(int a =0; a<=120; a++){
            for(int b =(int)(0.5*a)+8; b<=a; b++){
                count += arr[a]*arr[b];
               if(a==b) count -=arr[a];
            }
        }
        
        return count;
    }
}