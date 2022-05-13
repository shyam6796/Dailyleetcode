class Solution {
    public int nextGreaterElement(int n) {
        char arr[] = String.valueOf(n).toCharArray();
        int i=arr.length-2, j =arr.length-1;
        while(i>=0 && arr[i] >=arr[i+1]){
            i--;
        }
        if(i<0)return -1;
        while(j>=0 && arr[i] >=arr[j]){
            j--;
        }
        swap(arr,i,j);
        reverse(arr,i+1);
        try {
            return Integer.parseInt(new String(arr));
        } catch (Exception e) {
            return -1;
        }
    }
    public void reverse(char arr[], int i){
        int j =arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    
    public void swap(char arr[], int i, int j){
        char c =arr[i];
        arr[i] = arr[j];
        arr[j] =c;
    }
    
}