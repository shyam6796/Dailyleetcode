class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)return  new ArrayList<>();
        List<String> list =new ArrayList<>();
        HashMap<Integer,String> map =new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        helper(list,map,"",0,digits);
        return list;    
        }
    public void helper(List<String> list, HashMap<Integer,String> map, String ans, int i,String digits){
        if(ans.length()== digits.length()){
            list.add(ans);
            return;
        }
         String S = map.get(digits.charAt(i)-'0');                       
        for(int j=0; j<S.length(); j++){
            helper(list,map,ans+ S.charAt(j),i+1,digits);
        }
    }
}