class LRUCache {
    Map<Integer,Integer> map;
    int cap;
    public LRUCache(int capacity) {
       cap = capacity;
       map = new LinkedHashMap<>(); 
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;

        int val = map.remove(key);
        map.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            get(key);
        }else{
            if(cap==map.size()){
                for(int i : map.keySet()){
                    map.remove(i);
                    break;
                }
            }
        }

        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */