class MovingAverage {
    List<Integer>list= new ArrayList<>();
    int n;
    double sum=0;
    
    public MovingAverage(int size) {
        n =size;
    }
    
    public double next(int val) {
        list.add(0,val);
        if(list.size() <=n){
            sum +=val;
            return sum/list.size();
        }
        sum +=val;
        sum-=list.get(n);
        return sum/n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */