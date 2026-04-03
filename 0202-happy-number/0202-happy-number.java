class Solution {
    public boolean isHappy(int n) {
        int fast =n;
        int slow =n;

        do{
             fast= helper(helper(fast));
            slow =helper(slow);
            if(fast==1 || fast ==7)return true;
        }while(fast !=slow);
        return false;
        
       
    }

    public int helper(int n){
        String str =Integer.toString(n);
        int val =0;
        for(int i=0; i <str.length(); i++){
            char c = str.charAt(i);
            val +=(c-'0') *(c-'0');
        }
        return val;
    }
}