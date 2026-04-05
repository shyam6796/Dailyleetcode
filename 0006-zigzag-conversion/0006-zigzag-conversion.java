class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <=numRows)return s;
        Map<Integer,StringBuilder> map = new HashMap<>();
        int row =0;
        boolean dir =true;
        for(int i=0; i < s.length(); i++){
            if(row==numRows-1)dir=false;
            if(row==0)dir=true;
            if(!map.containsKey(row))map.put(row, new StringBuilder());
            map.get(row).append(s.charAt(i));
            if(dir){
                row++;
            }else{
                row--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : map.keySet()){
            sb.append(map.get(i));
        }
        return sb.toString();
    }
}