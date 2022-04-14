class LRUCache {
    Map<Integer,Integer> map;
    int size;
    public LRUCache(int capacity) {
        map =new LinkedHashMap<>();
        size=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        int value =map.remove(key);
        map.put(key,value);
        return value;
    }
    
    public void put(int key, int value) {
       if(!map.containsKey(key)){
            map.put(key,value);
        }else{
            map.remove(key);
            map.put(key,value);
        }
    if(map.size() >size){
            for(int i :map.keySet()){
                map.remove(i);
                break;
            }
    }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */