class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb =new StringBuilder();

        for(int i : nums)list.add(i+"");
        Collections.sort(list,(a,b) -> func(a,b));

        for(String s : list) sb.append(s);
        
        if(checkZero(sb.toString()))return "0";
        
        while(sb.length() >1 && sb.charAt(0)==0)sb.deleteCharAt(0);

        return sb.toString();

    }

    public int func(String a, String b){
        int i =0;
        int j =0;
        while(i < a.length() || j < b.length()){
            if(i==a.length()) i=0;
            if(j==b.length()) j=0;
            if(a.charAt(i) ==b.charAt(j)){
                i++;
                j++;
            }else if(a.charAt(i) > b.charAt(j))return -1;
            else return 1;
        }
        return 0;
    }

    public boolean checkZero(String s){
        int index =0;
        while(index < s.length()) if(s.charAt(index++) !='0')return false;
        return true;
    }
}