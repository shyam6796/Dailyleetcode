class AllOne {
    HashMap<String,Integer> map;
     TreeMap<Integer, List<String>> treeMap;
    public AllOne() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }
    
    public void inc(String key) {
       
        if(map.containsKey(key)){
             int oldCnt = map.get(key);
             removeCount(key, oldCnt);
             updateCount(key, oldCnt+1);
        }else   updateCount(key, 1);
    }
    
    public void dec(String key) {
         if(!map.containsKey(key)){
             return ;
        }
        int oldCnt = map.get(key);

		removeCount(key, oldCnt);
        	if (oldCnt == 1) {
			map.remove(key);
		} else {
			updateCount(key, oldCnt - 1);
		}
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
       return  treeMap.firstEntry().getValue().get(0); 
    }
    
    public void removeCount(String key, int count){
        List<String> list = treeMap.get(count);
		list.remove(key);
		if (list.size() == 0) {
			treeMap.remove(count);
        } 
    }
    
    public void updateCount(String key, int count){
        map.put(key,count);
        
        if(!treeMap.containsKey(count)) treeMap.put(count,new ArrayList<>());
        treeMap.get(count).add(key);        
    
    
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