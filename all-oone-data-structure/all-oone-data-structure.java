class AllOne {
    HashMap<String,Integer> map;
    TreeMap<Integer,List<String>> treeMap;
    public AllOne() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        
        if(map.containsKey(key)){
            int oldCount = map.get(key);
            removeKey(key,oldCount);
            updateKey(key,oldCount+1);
        }else{
            updateKey(key,1);
        }
    }
    
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        int oldCount = map.get(key);
        removeKey(key,oldCount); 
        if(oldCount==1){
            map.remove(key);        
        }else{
             updateKey(key,oldCount-1);
        }
    
       
        
        
    }
    
    public void removeKey(String key, int count){
        List<String> list = treeMap.get(count);
        list.remove(key);
        if (list.size() == 0) {
			treeMap.remove(count);
        } 
    }
    
    public void updateKey(String key, int count){
        map.put(key,count);
        if(!treeMap.containsKey(count)){
            treeMap.put(count, new ArrayList<>());
        }
        treeMap.get(count).add(key);
    }
    
    public String getMaxKey() {
        if (treeMap.size() == 0) {
			return "";
		}
      return  treeMap.lastEntry().getValue().get(0);
    }
    
    public String getMinKey() {
        if (treeMap.size() == 0) {
			return "";
		}
        return treeMap.firstEntry().getValue().get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */