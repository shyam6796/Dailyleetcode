class Solution {
    public int maximumSwap(int num) {
        int []map =new int[10];
        char[] arr = String.valueOf(num).toCharArray();
        for(int i =0; i<arr.length; i++){
            map[arr[i] -'0']=i;
        }
        
        for(int i =0; i<arr.length; i++){
            int digit= arr[i] -'0';
            for(int j=9; j >digit; j--){
                if(map[j]> i){
                    char c =arr[i];
                    arr[i] =arr[map[j]];
                    arr[map[j]] =c;
                    
                     return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}