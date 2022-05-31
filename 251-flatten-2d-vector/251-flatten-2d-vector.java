class Vector2D {
    private int [][] vec;
    private int i;
    private int j;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        i = 0;
        j = 0;
    }
    
    public int next() {
        while (vec[i].length == 0) {
            ++i;
        }
        int ans = vec[i][j];
        if (j<vec[i].length-1) {
            j++;
        }
        else {
            ++i;
            j = 0;
        }
        return ans;
    }
    
    public boolean hasNext() {
        if (i < vec.length) {
            while (i < vec.length && vec[i].length == 0) {
                ++i;
            }
            if (i==vec.length) {
                return false;
            }
            else if (j<vec[i].length) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */