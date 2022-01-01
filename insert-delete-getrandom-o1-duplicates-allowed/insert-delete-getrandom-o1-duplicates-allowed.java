class RandomizedCollection {
    List<Integer> list;
     HashMap<Integer, Set<Integer>> idx;
    Random rand = new Random();
    public RandomizedCollection() {
        list= new ArrayList<>();
        idx = new HashMap<Integer, Set<Integer>>();
    }
    
    public boolean insert(int val) {
        if(!idx.containsKey(val))idx.put(val ,new LinkedHashSet<>());
        idx.get(val).add(list.size());
        list.add(val);
        return idx.get(val).size() ==1;
    }
    
    public boolean remove(int val) {
         if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
          int remove_idx=-1;
        for(int i : idx.get(val)){
               remove_idx=i;
               break;
           }
      
        
            idx.get(val).remove(remove_idx);
            int last = list.get(list.size() - 1);
            list.set(remove_idx,last);
            idx.get(last).add(remove_idx);
            idx.get(last).remove(list.size()-1);
        
            list.remove(list.size() - 1);
        
            return true;
        
    }
    
    public int getRandom() {
        int index =rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */