class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
      map.put('V',5);
      map.put('X',10);
      map.put('L',50);
      map.put('C',100);
      map.put('D',500);
      map.put('M',1000);


        int index =0;
        int ans =0;
        while(index <s.length()){
            if(index < s.length()-1 && map.get(s.charAt(index)) < map.get(s.charAt(index+1))){
                ans += map.get(s.charAt(index+1)) -map.get(s.charAt(index));
                index +=2;
            }else {
                 ans += map.get(s.charAt(index));
                 index++;
            }
        }
        return ans;
    }
}