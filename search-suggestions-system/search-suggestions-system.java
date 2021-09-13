class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       TreeMap<String,Integer> map = new TreeMap<>();
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
       List<String> list = Arrays.asList(products);
       for(int i=0; i<products.length; i++){
           map.put(products[i],i);
       }
       String key ="";
       for(char c :searchWord.toCharArray()){
           key +=c;
          String from = map.ceilingKey(key);
          String to = map.floorKey(key+"~");
           if(from ==null || to == null)break;
           ans.add(list.subList(map.get(from), Math.min(map.get(from)+3, map.get(to)+1)));
       }
       while(ans.size()<searchWord.length()) ans.add(new ArrayList<>());
        return ans;
    }
}