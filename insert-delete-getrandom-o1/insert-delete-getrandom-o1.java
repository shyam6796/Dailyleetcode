class RandomizedSet {
    HashSet<Integer> set;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val)){
           return false; 
        }
        set.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //Rand rand =new Rand();
        Integer[] arr = set.toArray(new Integer[set.size()]);
        int index = rand.nextInt(set.size());
        return arr[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */