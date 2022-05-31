class Solution {
    public int titleToNumber(String s) {
       int ans = 0;
       int i= s.length()-1,base=0;
      
       while(i>= 0){
           int temp=0;
           temp = s.charAt(i) -'A' +1;
           int baseCount =(int)Math.pow(26,base);
            //System.out.println(i);
           ans += temp*baseCount;
           base++;
           i--;
           
           
       }
        return ans;
    }
}

 