class Solution {
    public int myAtoi(String s) {
        int index =0;
        int val = 0;
        int sign = '+';

        while(index < s.length()&& s.charAt(index)== ' ')index++;
        if(index <s.length() && (s.charAt(index)=='+' || s.charAt(index)=='-')){
            sign = s.charAt(index);
            index++;
        }

        while(index < s.length() && Character.isDigit(s.charAt(index))){
            char c= s.charAt(index);
            if(val >Integer.MAX_VALUE/10 ||(val ==Integer.MAX_VALUE/10 && Integer.MAX_VALUE %10 < c -'0')){
                return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + c -'0';
            index++;
        }

        return sign =='-' ? -1 * val : val;

    }
}