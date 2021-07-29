class MovingAverage {
    List<Integer> list;
    int n;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list= new ArrayList<>();
        n=size;
    }
    
    public double next(int val) {
        list.add(0,val);
        int temp =0;
        if(list.size()<n){ 
             for(int i :list){
                temp +=i;
            }
            return (double)temp/list.size();
            
        }else{
            for(int i=0; i<n; i++){
                temp +=list.get(i);
            }
            return (double)temp/n;
        }
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */