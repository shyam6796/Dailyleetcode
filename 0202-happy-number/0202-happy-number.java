class Solution {
    public boolean isHappy(int n) {
        int fast =n;
        int slow =n;
        do{
            fast = func(func(fast));
            slow = func(slow);
            if(fast ==1)return true;
        }while(fast !=slow);
        return false;
    }

    public int func(int n){
        String str = Integer.toString(n);
        int val =0;

        for(int i =0; i <str.length(); i++){
            int x =str.charAt(i) -'0';
            val +=(x*x);
        }
        return val;
    }
}