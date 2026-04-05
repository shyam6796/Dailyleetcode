class LFUCache {
    Map<Integer,Integer> keyValueMap;
    Map<Integer,Integer> keyFreqMap;
    Map<Integer,Set<Integer>> freqMap;
    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        keyValueMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1,new LinkedHashSet<>());
        cap =capacity;
        minFreq =-1;
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)) return -1;

        int freq = keyFreqMap.get(key);
        keyFreqMap.put(key,freq+1);

        freqMap.get(freq).remove(key);
        if(freqMap.get(freq).size()==0 && minFreq ==freq) minFreq++;

        if(!freqMap.containsKey(freq+1))freqMap.put(freq+1,new LinkedHashSet<>());
        freqMap.get(freq+1).add(key);

        return keyValueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(keyValueMap.containsKey(key)){
            get(key);
            keyValueMap.put(key,value);
        }else{
            if(cap==keyValueMap.size()){
                Set<Integer> set = freqMap.get(minFreq);
                for(int i : set){
                    keyValueMap.remove(i);
                    keyFreqMap.remove(i);
                    set.remove(i);
                    break;
                }
            }
            keyFreqMap.put(key,1);
            freqMap.get(1).add(key);
            keyValueMap.put(key, value);
            minFreq =1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */