class TwoSum {
    List<Integer> list;
    public TwoSum() {
    list = new ArrayList<>();
    }
    
    public void add(int number) {
        list.add(number);
    }
    
    public boolean find(int value) {
        Set <Integer> set = new HashSet<>();
        
        for(int i=0; i<list.size(); i++){
            int comp =value -list.get(i);
           // System.out.println(set);
            //.out.println(comp);
            if(set.contains(list.get(i))){
                return true;
            }
            set.add(comp);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */