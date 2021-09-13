class LFUCache {
    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    Map<Integer, Set<Integer>> freqMap = new HashMap<>();
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key))
            return -1;
        // Get the current key's freq
        int freq = keyFreqMap.get(key);

        // Update current key's freq
        keyFreqMap.put(key, freq + 1);
        freqMap.get(freq).remove(key);

        // Update the min freq
        if (freq == min && freqMap.get(freq).size() == 0)
            min++;

        // Update current key's freq
        if (!freqMap.containsKey(freq + 1))
            freqMap.put(freq + 1, new LinkedHashSet<>());
        freqMap.get(freq + 1).add(key);

        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        // Base case
        if (cap == 0)
            return;

        // Update value
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);// update the freq for the current key
        } else {
            // Check if exceed the capacity
            if (keyValueMap.size() == cap) {
                Set<Integer> curlist = freqMap.get(min);
                for(int i :curlist){
                   curlist.remove(i); 
                keyValueMap.remove(i);
                    break;
                }
                
            }
            keyValueMap.put(key, value);
            keyFreqMap.put(key, 1);
            min = 1;// because we just add a new element
            freqMap.get(1).add(key);
        }
    }

   
}
