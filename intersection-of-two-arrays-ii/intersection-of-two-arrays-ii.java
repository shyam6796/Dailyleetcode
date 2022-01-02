class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i :nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        for(int i :nums2){
            if(map.containsKey(i) && map.get(i) >0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        
       int [] ints = new int[list.size()];
        for(int i=0; i < list.size(); i++){
            ints[i] =list.get(i);
        }
        
        return ints;
    }
}