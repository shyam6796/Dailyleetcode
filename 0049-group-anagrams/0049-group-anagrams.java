class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = helper(str);
            if(!map.containsKey(key))map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        list.addAll(map.values());
        return list;
    }

    public String helper(String s){
        char [] arr =new char[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        return  new String(arr);
    }
}