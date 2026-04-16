class MyHashMap {
    class Pair{
        int key;
        int value;
        public Pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    List<List<Pair>> list ;
    int cap;
    public MyHashMap() {
        cap=1000;
        list =new ArrayList<>();

        for(int i=0; i <cap; i++){
            list.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        int k = getHash(key);
        List<Pair> ls = list.get(k);

        for(int i=0; i <ls.size(); i++){
            if(ls.get(i).key ==key){
                ls.get(i).value =value;
                return;
            }
        }
        ls.add(new Pair(key, value));
    }
    
    public int get(int key) {
         int k = getHash(key);
        List<Pair> ls = list.get(k);

         for(int i=0; i <ls.size(); i++){
            if(ls.get(i).key ==key){
               return ls.get(i).value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
       int i =getHash(key);
       List<Pair> ls = list.get(i);
       for(int j =0; j <ls.size(); j++){
            Pair pr = ls.get(j);
            if(pr.key==key){
                ls.remove(j);
                return;
            }
       }
    }

    public int getHash(int key){
        return key%cap;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */