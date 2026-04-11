class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carr =0;
        int i = a.length()-1;
        int j = b.length()-1;

        while(i >=0  || j >=0){
            int x = i <0  ? 0: a.charAt(i--) -'0';
            int y = j <0  ? 0: b.charAt(j--) -'0';
            int sum =x +y+carr;
            carr = sum/2;
            sum = sum %2;
            sb.append(sum);
        }
        if(carr !=0)sb.append(carr);
        return sb.reverse().toString();
    }
}