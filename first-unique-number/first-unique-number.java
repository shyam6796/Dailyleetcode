class FirstUnique {
    Map< Integer,Integer> map = new LinkedHashMap<>();
    public FirstUnique(int[] nums) {
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.replace(i,map.get(i)+1);
        }
      //  System.out.println(map);
    }
    
    public int showFirstUnique() {
        for(int i : map.keySet()){
            if(map.get(i)==1)return i;
        }
        return -1;
    }
    
    public void add(int i) {
         if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.replace(i,map.get(i)+1);
       // System.out.println(map);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */