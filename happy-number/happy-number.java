class Solution {
    public boolean isHappy(int n) {
           
        while(n>9){
            String s =String.valueOf(n);
            n=0;
            for(int j =0; j < s.length(); j++){
                   int temp= s.charAt(j) -'0';
                   n += temp * temp;
                
            }
            //System.out.println(n);
        }  
            if( n ==1 ||n==7)return true;
            else return false;
        
    }
}