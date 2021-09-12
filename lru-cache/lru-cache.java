class LRUCache {
    Map<Integer,Integer> map;
    int c;
    public LRUCache(int capacity) {
         map = new LinkedHashMap<>();
        c = capacity;
    }
    
    public int get(int key) {
        int ans =-1;
        if(map.containsKey(key)){
            ans= map.remove(key);
            map.put(key,ans);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key))map.put(key,value);
        else{
            map.remove(key);
             map.put(key,value);
        }
         if(map.size()>c){
             for(int i : map.keySet()){
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