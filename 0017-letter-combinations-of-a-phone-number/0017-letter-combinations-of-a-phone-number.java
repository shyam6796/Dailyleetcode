class Solution {
     public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
         map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        helper(map, list, digits, "", 0);
        return list;
    }

    public void helper(Map<Integer,String> map,List<String> list , String digits, String str, int index){
        if(index ==digits.length()){
            list.add(str);
            return;
        }
        String s = map.get(digits.charAt(index) -'0');
        
        for(int i =0; i < s.length(); i++){
            helper(map, list, digits, str+s.charAt(i), index+1);
        }
    }
}